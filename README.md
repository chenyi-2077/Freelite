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

### A — 用户系统说明书（陈怡安）

| 章节 | 内容 | 需画图 |
|---|---|---|
| 绪论 | 项目背景、用户系统定位 | — |
| 需求分析 | 注册/登录/资料编辑功能需求、用例描述 | — |
| 数据库设计 | User 表字段定义、关系说明 | ER 图 |
| 功能模块图 | 用户系统子功能拆解（注册→校验/查重/加密） | 树状功能模块图 |
| 核心业务流程 | 用户注册流程、登录JWT鉴权流程、资料编辑流程 | 用户注册流程图、登录JWT鉴权时序图、资料编辑流程图 |
| 界面设计与核心代码 | login.jsp/register.jsp/profile.jsp/editProfile.jsp 截图 + LoginServlet/RegisterServlet 代码 | 界面截图 |
| 测试用例 | 注册成功、重复用户名、密码错误、未登录访问资料 | 三线表 |
| 功能总结与致谢 | 技术亮点、遇到的困难、致谢 | — |

### B — 项目发布与浏览说明书（陈凯博）

| 章节 | 内容 | 需画图 |
|---|---|---|
| 绪论 | 项目发布模块定位 | — |
| 需求分析 | 发布项目/浏览列表/详情查看/分类筛选功能需求 | — |
| 数据库设计 | Project 表、Category 表字段定义 | ER 图 |
| 功能模块图 | 项目系统子功能拆解 | 树状功能模块图 |
| 核心业务流程 | 发布项目流程、项目列表分页+筛选流程、项目详情查看流程 | 发布项目流程图、项目列表筛选流程图、项目详情查看流程图 |
| 界面设计与核心代码 | postProject.jsp/projectList.jsp/projectDetail.jsp 截图 + PostProjectServlet/ProjectListServlet 代码 | 界面截图 |
| 测试用例 | 发布成功、字段为空、不登录访问、分类筛选 | 三线表 |
| 功能总结与致谢 | 技术亮点、遇到的困难、致谢 | — |

### C — 竞标系统说明书（陈僖睿）

| 章节 | 内容 | 需画图 |
|---|---|---|
| 绪论 | 竞标系统定位 | — |
| 需求分析 | 提交竞标/竞标列表/中标授标/我的竞标功能需求 | — |
| 数据库设计 | Bid 表字段定义、与 Project/User 关系 | ER 图 |
| 功能模块图 | 竞标系统子功能拆解 | 树状功能模块图 |
| 核心业务流程 | 提交竞标流程、雇主授标流程、查看竞标列表流程 | 提交竞标流程图、授标时序图、竞标列表流程图 |
| 界面设计与核心代码 | bidForm.jsp/bidsOnProject.jsp/myBids.jsp 截图 + PlaceBidServlet/AwardBidServlet 代码 | 界面截图 |
| 测试用例 | 竞标成功、重复竞标、未登录竞标、雇主授标 | 三线表 |
| 功能总结与致谢 | 技术亮点、遇到的困难、致谢 | — |

### D — 订单与评价说明书（陈子豪）

| 章节 | 内容 | 需画图 |
|---|---|---|
| 绪论 | 订单与评价模块定位 | — |
| 需求分析 | 订单管理/订单完成/评价/数据看板功能需求 | — |
| 数据库设计 | Order 表、Review 表字段定义、与 Project/User 关系 | ER 图 |
| 功能模块图 | 订单与评价系统子功能拆解 | 树状功能模块图 |
| 核心业务流程 | 中标→订单创建流程、订单完成流程、评价流程、数据看板统计逻辑 | 订单创建流程图、订单完成流程图、评价流程图、数据看板统计流程图 |
| 界面设计与核心代码 | dashboard.jsp/orderList.jsp/orderDetail.jsp 截图 + DashboardServlet/ReviewServlet 代码 | 界面截图 |
| 测试用例 | 订单完成、提交评价、数据看板统计、未登录访问 | 三线表 |
| 功能总结与致谢 | 技术亮点、遇到的困难、致谢 | — |

### 🌐 整合版项目说明书（陈怡安 组长）

| 章节 | 内容 |
|---|---|
| 封面 | 项目名称、团队信息、日期 |
| 摘要 | 200 字项目整体概述 |
| 目录 | 全文档目录 |
| 第一章 项目概述 | 技术栈、整体架构图（B/S 三层架构）、整体功能模块图、系统主页 |
| 第二章 数据库设计与创建 | 全局 ER 图、全部表定义整合、database.sql 说明 |
| 第三章 各模块详解 | 四份说明书精编合并（A→D 按顺序） |
| 第四章 系统部署与使用说明 | Tomcat 部署步骤、MySQL 导入、运行截图 |
| 第五章 项目总结与展望 | 功能总结、不足与改进方向 |
| 参考文献 | JSP/Servlet/MySQL/Bootstrap 等技术引用 |
| 致谢 | — |

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

*Freelite — 让自由协作，如此简单* 🚀
