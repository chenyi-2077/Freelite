# Freelite 🚀

> 自由职业项目竞标平台 — 轻量版 Freelancer  
> **让自由协作，如此简单**

---

## 📋 项目简介

Freelite 是一个 B/S 架构的 Web 应用，对标 Freelancer.com 的核心功能：
雇主发布项目，自由职业者竞标接单，完成后评价评分。

**技术栈**：JSP + Bootstrap 5 + Java Servlet + JDBC + MySQL 5.7 + Tomcat 8.5

---

## 👥 团队

| 编号 | 成员 | 角色 | GitHub |
|---|---|---|---|
| ⭐ A | **陈怡安** | 组长 | [@chenyi-2077](https://github.com/chenyi-2077) |
| B | **陈凯博** | 组员 | — |
| C | **陈僖睿** | 组员 | — |
| D | **陈子豪** | 组员 | — |

---

## 🗺️ 项目说明书分工

### A — 👤 用户系统说明书（陈怡安）

1. 用户注册
2. 用户登录
3. JWT 认证鉴权
4. 个人资料管理
5. 用户信息编辑
6. 权限控制
7. 用户密码修改
8. 用户注销
9. 管理员用户管理（列表/禁用/删除）
10. 用户模块数据库设计与创建（User 表）
11. 用户模块设计与实现

**对应源码**：User.java、LoginServlet.java、RegisterServlet.java、ProfileServlet.java、EditProfileServlet.java、LogoutServlet.java、UserDao.java、login.jsp、register.jsp、profile.jsp、editProfile.jsp

### B — 📋 项目发布与浏览说明书（陈凯博）

1. 项目发布
2. 项目列表展示
3. 项目分类筛选
4. 项目详情查看
5. 项目搜索（关键词）
6. 项目状态管理（开放/进行中/已关闭）
7. 项目编辑/删除（雇主）
8. 我的项目列表（雇主视角）
9. 项目模块数据库设计与创建（Project 表、Category 表）
10. 项目模块设计与实现

**对应源码**：Project.java、Category.java、PostProjectServlet.java、ProjectListServlet.java、ProjectDetailServlet.java、ProjectDao.java、CategoryDao.java、postProject.jsp、projectList.jsp、projectDetail.jsp

### C — 🏷️ 竞标系统说明书（陈僖睿）

1. 竞标提交
2. 竞标列表（项目视角）
3. 雇主授标
4. 我的竞标记录（自由职业者视角）
5. 竞标撤回
6. 竞标消息沟通
7. 竞标者资料查看
8. 竞标模块数据库设计与创建（Bid 表）
9. 竞标模块设计与实现

**对应源码**：Bid.java、PlaceBidServlet.java、BidListServlet.java、AwardBidServlet.java、MyBidsServlet.java、BidDao.java、bidForm.jsp、bidsOnProject.jsp、myBids.jsp

### D — ⭐ 订单与评价说明书（陈子豪）

1. 订单管理（列表/详情）
2. 订单创建（中标→自动生成）
3. 订单完成确认
4. 订单取消（争议）
5. 评价提交（评分+评论）
6. 评价列表查看
7. 数据看板（项目/竞标/订单/评价统计）
8. Excel 报表导出
9. 订单与评价模块数据库设计与创建（Order 表、Review 表）
10. 订单模块设计与实现

**对应源码**：Order.java、Review.java、CompleteOrderServlet.java、OrderListServlet.java、OrderDetailServlet.java、ReviewServlet.java、DashboardServlet.java、OrderDao.java、ReviewDao.java、dashboard.jsp、orderList.jsp、orderDetail.jsp

### 🌐 整合版项目说明书（陈怡安 — 组长额外）

1. 项目架构设计与搭建
2. Docker 部署方案
3. 分页/工具类基础架构
4. 数据库 SQL 初始化脚本
5. 公用组件（DBUtil、index.jsp）
6. 整合版项目说明书（合并四模块 + 项目架构 + 部署文档 + 参考文献 + 致谢）

---

## ⚙️ 快速开始

### 环境要求

- JDK 8+
- Apache Tomcat 8.5+
- MySQL 5.7+
- IDE：Eclipse 2026-03（或任意支持 Dynamic Web Project 的 IDE）

### 运行步骤

**1. Clone 项目**

```bash
git clone https://github.com/chenyi-2077/Freelite.git
```

**2. 导入 Eclipse**

File → Import → General → Existing Projects into Workspace → 选择 Freelite 文件夹

> 确保 Eclipse 已配置 Tomcat Server：Window → Preferences → Server → Runtime Environments

**3. 创建数据库**

```bash
mysql -u root -p < docs/database.sql
```

**4. 修改数据库连接配置**

打开 `src/com/freelite/util/DBUtil.java`，按实际环境修改：

```java
private static final String URL = "jdbc:mysql://localhost:3306/freelite?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "***";
```

**5. 启动项目**

右键项目 → Run As → Run on Server → 选择 Tomcat → 浏览器自动打开 `http://localhost:8080/Freelite/`

---

## 🗂️ 项目文件结构

```
Freelite/
├── README.md
├── docs/
│   ├── database.sql
│   └── 说明书分工.md
├── WebContent/
│   ├── WEB-INF/web.xml
│   ├── A-user/         ← 用户模块（A 陈怡安）
│   ├── B-project/      ← 项目模块（B 陈凯博）
│   ├── C-bid/          ← 竞标模块（C 陈僖睿）
│   ├── D-order/        ← 订单模块（D 陈子豪）
│   └── index.jsp / index.html
├── src/com/freelite/
│   ├── model/          ← 实体类（User/Project/Category/Bid/Order/Review）
│   ├── dao/            ← 数据访问层
│   ├── servlet/        ← 控制层（15 个 Servlet）
│   └── util/           ← 工具类（DBUtil、JWTUtil）
└── .gitignore
```

---

## 📚 说明书文件

| 文件 | 负责人 | 状态 |
|---|---|---|
| `docs/说明书分工.md` | 陈怡安 | ✅ 已更新 |
| `docs/说明书_用户系统.md` | 陈怡安 | ⬜ 待编写 |
| `docs/说明书_项目发布与浏览.md` | 陈凯博 | ⬜ 待编写 |
| `docs/说明书_竞标系统.md` | 陈僖睿 | ⬜ 待编写 |
| `docs/说明书_订单与评价.md` | 陈子豪 | ⬜ 待编写 |
| `docs/说明书_整合版.md` | 陈怡安 | ⬜ 待编写 |

---

*Freelite — 让自由协作，如此简单* 🚀
