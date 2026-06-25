# Freelite 🚀

> 自由职业项目竞标平台 — 轻量版 Freelancer  
> **让自由协作，如此简单**

---

## 📋 项目简介

Freelite 是一个 B/S 架构的 Web 应用，对标 Freelancer.com 的核心功能：
雇主发布项目，自由职业者竞标接单，完成后评价评分。

**技术栈**：JSP + Bootstrap 5 + Java Servlet + JDBC + MySQL 5.7 + Tomcat 8.5

## 👥 团队与分工

| 学号 | 姓名 | 程序模块分工 | 说明书分工 |
|---|---|---|---|
| 24030505 | **陈怡安** | 用户注册、登录、JWT 认证鉴权、个人资料管理、信息编辑、权限控制、密码修改、用户注销、管理员用户管理 | 用户系统模块说明书、整合版项目说明书 |
| 24030503 | **陈凯博** | 项目发布、项目列表展示、分类筛选、项目详情、项目搜索、项目状态管理、项目编辑/删除、我的项目列表 | 项目发布与浏览模块说明书 |
| 24030504 | **陈僖睿** | 竞标提交、竞标列表、雇主授标、我的竞标记录、竞标撤回、竞标消息沟通、竞标者资料查看 | 竞标系统模块说明书 |
| 24030506 | **陈子豪** | 订单管理、订单创建、订单完成确认、订单取消、评价提交、评价列表查看、数据看板、Excel 报表导出 | 订单与评价模块说明书 |

> **选题**：自由职业任务集市（Freelite）
> **技术栈**：JSP + Bootstrap 5 + Java Servlet + JDBC + MySQL 5.7 + Tomcat 8.5
>
> 📘 详细模块功能说明和对应源码 → [docs/说明书分工.md](docs/说明书分工.md)

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
