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

## 🗺️ 功能模块图

### A — 👤 用户系统（陈怡安）

```
用户系统 ─┬─ 注册功能 ─┬─ register.jsp — 注册表单页面（用户名/密码/邮箱/姓名/角色）
          │            ├─ RegisterServlet.java — 接收注册请求，校验字段，检测用户名重复
          │            └─ UserDao.java — 注册 insert、用户名查重 query
          │
          ├─ 登录功能 ─┬─ login.jsp — 登录表单页面（用户名/密码/角色选择）
          │            ├─ LoginServlet.java — 接收登录请求，校验密码，生成 JWT 令牌
          │            ├─ LogoutServlet.java — 登出，清除 JWT
          │            └─ UserDao.java — 用户名密码查询
          │
          ├─ 个人资料 ─┬─ profile.jsp — 个人资料展示页面
          │            ├─ ProfileServlet.java — 根据 JWT 获取用户信息并展示
          │            ├─ editProfile.jsp — 编辑资料表单页面
          │            ├─ EditProfileServlet.java — 保存编辑后的资料
          │            └─ UserDao.java — 用户信息查询、更新
          │
          └─ 数据模型 ─── User.java — 用户实体类（id/username/password/name/email/role/createdAt）
```

### B — 📋 项目发布与浏览（陈凯博）

```
项目系统 ─┬─ 发布项目 ─┬─ postProject.jsp — 发布项目表单（标题/描述/预算/分类/截止日期）
          │            ├─ PostProjectServlet.java — 接收发布请求，校验字段，写入数据库
          │            └─ ProjectDao.java — 项目 insert
          │
          ├─ 项目列表 ─┬─ projectList.jsp — 项目列表展示页面（分页 + 分类筛选）
          │            ├─ ProjectListServlet.java — 查询项目列表，支持分页和分类筛选
          │            └─ ProjectDao.java — 项目多条件查询、分页
          │
          ├─ 项目详情 ─┬─ projectDetail.jsp — 项目详情展示页面
          │            ├─ ProjectDetailServlet.java — 查询单个项目完整信息
          │            └─ ProjectDao.java — 按 ID 查询项目
          │
          ├─ 分类管理 ─┬─ CategoryDao.java — 分类数据查询
          │            └─ Category.java — 分类实体类（id/name）
          │
          └─ 数据模型 ─── Project.java — 项目实体类（id/title/description/budget/categoryId/posterId/status/createdAt）
```

### C — 🏷️ 竞标系统（陈僖睿）

```
竞标系统 ─┬─ 提交竞标 ─┬─ bidForm.jsp — 竞标表单页面（出价金额/留言）
          │            ├─ PlaceBidServlet.java — 接收竞标请求，校验登录、项目状态、重复竞标
          │            └─ BidDao.java — 竞标 insert
          │
          ├─ 竞标列表 ─┬─ bidsOnProject.jsp — 项目下所有竞标列表页面
          │            ├─ BidListServlet.java — 查询指定项目下所有竞标
          │            └─ BidDao.java — 按项目 ID 查询竞标列表
          │
          ├─ 中标授标 ─┬─ AwardBidServlet.java — 雇主授标给竞标者，更新项目/竞标状态
          │            └─ BidDao.java / ProjectDao.java — 更新竞标和项目状态
          │
          ├─ 我的竞标 ─┬─ myBids.jsp — 当前用户的所有竞标记录页面
          │            ├─ MyBidsServlet.java — 查询当前用户提交的所有竞标
          │            └─ BidDao.java — 按用户 ID 查询竞标
          │
          └─ 数据模型 ─── Bid.java — 竞标实体类（id/projectId/bidderId/amount/message/status/createdAt）
```

### D — ⭐ 订单与评价（陈子豪）

```
订单系统 ─┬─ 订单管理 ─┬─ orderList.jsp — 订单列表页面（按用户角色显示不同视角）
          │            ├─ orderDetail.jsp — 订单详情页面
          │            ├─ OrderListServlet.java — 查询用户相关订单列表
          │            ├─ OrderDetailServlet.java — 查询单个订单详情
          │            └─ OrderDao.java — 订单增删改查
          │
          ├─ 完成订单 ─┬─ CompleteOrderServlet.java — 中标后创建订单，更新订单完成状态
          │            └─ OrderDao.java — 订单 insert / update
          │
          ├─ 评价系统 ─┬─ ReviewServlet.java — 订单完成后提交评价（评分+评论）
          │            └─ ReviewDao.java — 评价 insert / 按项目/用户查询
          │
          ├─ 数据看板 ─┬─ dashboard.jsp — 数据看板展示页面（统计图表）
          │            ├─ DashboardServlet.java — 统计数据：项目数、竞标数、订单数、评价
          │            ├─ ProjectDao.java — 项目统计查询
          │            ├─ BidDao.java — 竞标统计查询
          │            ├─ OrderDao.java — 订单统计查询
          │            └─ ReviewDao.java — 评价统计查询
          │
          └─ 数据模型 ─┬─ Order.java — 订单实体类（id/projectId/buyerId/sellerId/amount/status/createdAt）
                       └─ Review.java — 评价实体类（id/orderId/fromUserId/toUserId/rating/comment/createdAt）
```

### 🔧 公用组件（整合版说明书法完善）

```
公用 ─┬─ DBUtil.java — MySQL 数据库连接管理与关闭
      ├─ index.jsp / index.html — 首页/入口页面
      └─ 整合版说明书 — 四人模块合并 + 项目架构 + 部署文档 + 参考文献
```

---

## 📚 项目说明书分配

| 编号 | 说明书 | 负责人 | 字数要求 |
|---|---|---|---|
| 📄 A | **用户系统模块说明书** | **陈怡安** | 2000-4000 字 |
| 📄 B | **项目发布与浏览模块说明书** | **陈凯博** | 2000-4000 字 |
| 📄 C | **竞标系统模块说明书** | **陈僖睿** | 2000-4000 字 |
| 📄 D | **订单与评价模块说明书** | **陈子豪** | 2000-4000 字 |
| 📄 🌐 | **整合版项目说明书** | **陈怡安** | 四模块合并 |

> 📘 说明书编写详细模板与要求 → [docs/说明书分工.md](docs/说明书分工.md)
>
> 每份说明书需包含：绪论、需求分析、数据库设计(含ER图)、功能模块图、核心流程图、界面设计与核心代码、测试用例(三线表)、功能总结与致谢

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

## 🗂️ 项目文件结构一览

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
│   └── index.jsp
├── src/com/freelite/
│   ├── model/          ← 实体类（5 个）
│   ├── dao/            ← 数据访问层（10 个）
│   ├── servlet/        ← 控制层（15 个 Servlet）
│   └── util/           ← 工具类
└── .gitignore
```

---

*Freelite — 让自由协作，如此简单* 🚀
