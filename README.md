# Freelite 🚀

> 自由职业项目竞标平台 — 轻量版 Freelancer  
> **让自由协作，如此简单**

---

## 📋 项目简介

Freelite 是一个 B/S 架构的 Web 应用，对标 Freelancer.com 的核心功能：
雇主发布项目，自由职业者竞标接单，完成后评价评分。

**技术栈**：JSP + Bootstrap 5 + Java Servlet + JDBC + MySQL 5.7 + Tomcat 8.5

---

## 👥 团队与分工

| 编号 | 角色 | 成员 | GitHub | 负责模块 |
|---|---|---|---|---|
| ⭐ A | **组长** | **陈怡安** | [@chenyi-2077](https://github.com/chenyi-2077) | 用户系统（注册/登录/个人资料）+ 整合版说明书 |
| B | 组员 | **陈凯博** | — | 项目发布与浏览模块 |
| C | 组员 | **陈僖睿** | — | 竞标系统模块 |
| D | 组员 | **陈子豪** | — | 订单与评价模块 |

> 📄 **详细分工** → [docs/说明书分工.md](docs/说明书分工.md)

---

## 🗺️ 项目结构

```
Freelite/
├── README.md                        ← 项目说明（本文件）
├── docs/
│   ├── database.sql                 ← 数据库建表脚本
│   ├── 说明书分工.md                ← 项目说明书分工方案
│   ├── 说明书_用户系统.md            ← A 陈怡安
│   ├── 说明书_项目发布与浏览.md       ← B 陈凯博
│   ├── 说明书_竞标系统.md            ← C 陈僖睿
│   └── 说明书_订单与评价.md          ← D 陈子豪
├── WebContent/
│   ├── WEB-INF/web.xml
│   ├── A-user/                      ← 用户模块页面
│   ├── B-project/                   ← 项目模块页面
│   ├── C-bid/                       ← 竞标模块页面
│   └── D-order/                     ← 订单与看板页面
├── src/com/freelite/
│   ├── model/                       ← 实体类（User/Project/Bid/Order/Review）
│   ├── dao/                         ← 数据库访问层
│   ├── servlet/                     ← 控制层（12 个 Servlet）
│   └── util/                        ← 工具类（DBUtil/JWTUtil）
└── .gitignore
```

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
# 方式一：命令行直接导入
mysql -u root -p < docs/database.sql

# 方式二：在 MySQL Workbench 中打开 docs/database.sql 执行
```

**4. 修改数据库连接配置**

打开 `src/com/freelite/util/DBUtil.java`，按实际环境修改：

```java
private static final String URL = "jdbc:mysql://localhost:3306/freelite?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

**5. 启动项目**

右键项目 → Run As → Run on Server → 选择 Tomcat

浏览器自动打开 → 访问 `http://localhost:8080/Freelite/`

---

## 🔑 功能导览

| 模块 | 核心功能 | 关键页面 |
|---|---|---|
| 👤 **用户系统** | 注册 / 登录 / JWT 鉴权 / 个人资料编辑 | `login.jsp`, `register.jsp`, `profile.jsp` |
| 📋 **项目发布与浏览** | 发布项目 / 项目列表 / 详情 / 分类筛选 | `postProject.jsp`, `projectList.jsp`, `projectDetail.jsp` |
| 🏷️ **竞标系统** | 竞标出价 / 中标授标 / 我的竞标列表 | `bidForm.jsp`, `bidsOnProject.jsp`, `myBids.jsp` |
| ⭐ **订单与评价** | 订单管理 / 订单完成 / 评价 / 数据看板 | `dashboard.jsp`, `orderList.jsp`, `orderDetail.jsp` |

---

## 📚 文档

- [项目说明书分工方案](docs/说明书分工.md) — 各模块说明书编写要求
- [数据库设计脚本](docs/database.sql) — 完整的 DDL

---

*Freelite — 让自由协作，如此简单* 🚀
