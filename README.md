# Private-recipes
私家菜谱APP——唯有美食与爱不可辜负
## 1：项目介绍
### 1.1项目简介

>  私家菜谱APP是一款菜谱助手，在上面你可以轻松学习不一样的美食。做你最贴心的居家助手。

### 1.2功能介绍

  该项目分为客户端与服务端两部分。
  **服务端功能：   用户管理模块，菜谱模块，评论管理模块，点赞管理模块，排行统计模块。**


   - 用户管理模块的功能包括：管理员登录功能（管理员账户事先在数据库中设定，不提供注册功能）、查看所有用户、删除用户、搜索用户。

- 菜谱模块：可以进行菜谱列表的展示，单个菜谱的详情介绍（包括菜谱类型如川菜、湘菜等，图片，原材料，操作步骤），新增菜谱，菜谱修改，搜索菜谱。

- 评论管理模块：某个菜谱的评论、删除某个评论、评论中敏感词汇检查（如带有脏字评论自动使用*替换对应字或词）。

 -  点赞管理模块：浏览所有菜谱的点赞情况（默认按照点赞数降序排列）、搜索某菜谱的点赞情况。
功能截图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103502111.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103521699.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODY3MzQw,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103531503.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODY3MzQw,size_16,color_FFFFFF,t_70)
**客户端功能介绍：**
1.用户注册 2,.用户登录 3.个人信息展示 4.个人头像修改  5.个人其他基本信息修改 6.6.	在个人信息页可点击“我的点赞”，查看个人点赞过的菜谱
7.	在个人信息页可点击“我的评论”，查看个人评论过的信息及对应的菜谱
8.	在查看个人的所有评论时，可删除某评论（请求服务端提供的删除评论接口）
9.	菜谱分类展示（请求服务段提供的菜谱列表接口）
10.	菜谱详情展示（请求服务端提供的单个菜谱详情接口）
11.	搜索菜谱（请求服务端提供的搜索菜谱接口）
12.	点赞功能（请求服务端提供的点赞接口）
13.	评论功能（请求服务端提供的评论接口）
14.	查看点赞排行（请求服务端提供的点赞排行接口）
功能截图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103819909.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103827880.png)![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103835461.png)![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103844660.png)![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103853838.png)![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620103905234.png)
## 2：准备环境
AndroidStudio+Eclipse+tomcat+MySQL8.0
