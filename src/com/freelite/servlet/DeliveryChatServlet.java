package com.freelite.servlet;

import com.freelite.dao.*;
import com.freelite.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * 统一的交付与沟通页面
 * GET  /deliveryChat?projectId=X — 展示页面
 * POST /deliveryChat?action=message — 发送消息
 * POST /deliveryChat?action=upload — 上传交付物
 */
public class DeliveryChatServlet extends HttpServlet {

    private ProjectDao projectDao = new ProjectDao();
    private ProjectMessageDao messageDao = new ProjectMessageDao();
    private DeliveryDao deliveryDao = new DeliveryDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String projectIdStr = req.getParameter("projectId");
        if (projectIdStr == null || projectIdStr.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/projects");
            return;
        }

        int projectId = Integer.parseInt(projectIdStr);

        // 获取项目信息
        Project project = projectDao.findById(projectId);
        if (project == null) {
            resp.sendRedirect(req.getContextPath() + "/projects");
            return;
        }

        List<ProjectMessage> messages = messageDao.findByProjectId(projectId);
        List<Delivery> deliveries = deliveryDao.findByProjectId(projectId);

        req.setAttribute("projectId", projectId);
        req.setAttribute("project", project);
        req.setAttribute("projectTitle", project.getTitle());
        req.setAttribute("messages", messages);
        req.setAttribute("deliveries", deliveries);
        req.getRequestDispatcher("/deliveryChat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String projectIdStr = req.getParameter("projectId");
        String action = req.getParameter("action");
        if (projectIdStr == null || projectIdStr.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/projects");
            return;
        }
        int projectId = Integer.parseInt(projectIdStr);

        if ("message".equals(action)) {
            // 发送消息
            String content = req.getParameter("content");
            if (content != null && !content.trim().isEmpty()) {
                ProjectMessage msg = new ProjectMessage();
                msg.setProjectId(projectId);
                msg.setSenderId(loginUser.getId());
                msg.setContent(content.trim());
                messageDao.insert(msg);
            }
        } else if ("upload".equals(action)) {
            // 上传交付物
            String title = req.getParameter("title");
            String description = req.getParameter("description");

            Delivery delivery = new Delivery();
            delivery.setUserId(loginUser.getId());
            delivery.setTitle(title != null ? title : "");
            delivery.setDescription(description != null ? description : "");

            try {
                Part filePart = req.getPart("file");
                if (filePart != null && filePart.getSize() > 0) {
                    String originalName = filePart.getSubmittedFileName();
                    if (originalName != null && !originalName.isEmpty()) {
                        String ext = "";
                        int dotIdx = originalName.lastIndexOf('.');
                        if (dotIdx > 0) ext = originalName.substring(dotIdx);
                        String safeName = UUID.randomUUID().toString() + ext;

                        String datePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
                        String uploadDir = getServletContext().getRealPath("/WEB-INF/uploads/" + datePath);
                        new File(uploadDir).mkdirs();

                        String filePath = datePath + "/" + safeName;
                        filePart.write(uploadDir + "/" + safeName);

                        delivery.setFileName(originalName);
                        delivery.setFilePath(filePath);
                        delivery.setFileSize(filePart.getSize());
                        delivery.setFileType(filePart.getContentType());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            deliveryDao.insert(delivery);
            req.getSession().setAttribute("successMsg", "✅ 交付物已上传");
        }

        resp.sendRedirect(req.getContextPath() + "/deliveryChat?projectId=" + projectId);
    }
}
