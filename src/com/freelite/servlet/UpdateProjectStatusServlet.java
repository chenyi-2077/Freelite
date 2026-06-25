package com.freelite.servlet;

import com.freelite.dao.*;
import com.freelite.model.*;
import com.freelite.service.EscrowService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateProjectStatusServlet extends HttpServlet {

    private ProjectDao projectDao = new ProjectDao();
    private OrderDao orderDao = new OrderDao();
    private EscrowService escrowService = new EscrowService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        int projectId = Integer.parseInt(req.getParameter("id"));
        String newStatus = req.getParameter("status");
        String redirect = req.getParameter("redirect");

        Project project = projectDao.findById(projectId);
        if (project == null || project.getEmployerId() != loginUser.getId()) {
            resp.sendRedirect(req.getContextPath() + "/projects");
            return;
        }

        // 校验状态转换是否合法
        String current = project.getStatus();
        boolean valid = false;
        switch (newStatus) {
            case "cancelled":
                if ("open".equals(current) || "in_progress".equals(current)) valid = true;
                break;
            case "open":
                if ("cancelled".equals(current)) valid = true;
                break;
        }

        if (!valid) {
            resp.sendRedirect(req.getContextPath() + "/project/" + projectId);
            return;
        }

        projectDao.updateStatus(projectId, newStatus);

        // 取消项目时：取消关联订单 + 退冻结资金
        if ("cancelled".equals(newStatus)) {
            List<Order> orders = orderDao.findByProject(projectId);
            if (orders != null) {
                for (Order order : orders) {
                    String orderStatus = order.getStatus();
                    // 只取消进行中/等待确认的订单
                    if ("in_progress".equals(orderStatus) || "awaiting_confirm".equals(orderStatus)) {
                        // 如有冻结资金则退款给雇主
                        double escrowAmount = order.getEscrowAmount();
                        if (escrowAmount > 0) {
                            escrowService.refundToEmployer(projectId, order.getEmployerId(), escrowAmount);
                        }
                        orderDao.updateStatus(order.getId(), "cancelled");
                    }
                }
            }
        }

        if (redirect != null && !redirect.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + redirect);
        } else {
            resp.sendRedirect(req.getContextPath() + "/project/" + projectId);
        }
    }
}
