<%@ page import="java.util.List" %>
<%@ page import="com.tw.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/8/15
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户信息</title>
  <link href="./lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <script src="./js/user.js"></script>

  <script src="./lib/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><a href="./index"> 首页 </a></li>
            <li class="active"><a href="./users">用户管理</a> </li>
            <li><a href="./users">员工管理</a> </li>
            <li><a href="./courses">课程管理</a> </li>
            <li><a href="./customers">顾客管理</a> </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a type="button" href="./logout">退出登录</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <table class="table table-bordered">
      <caption><h2>用户信息表</h2></caption>
      <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>年龄</th>
        <th>修改</th>
        <th>删除</th>
      </tr>
      <%
        List<User> users = (List<User>)request.getAttribute("users");

        for(int i=0; i<users.size(); i++){
      %>
      <tr>
        <td><%= users.get(i).getName()%></td>
        <td><%= users.get(i).getGender()%></td>
        <td><%= users.get(i).getPassword()%></td>
        <td><%= users.get(i).getEmail()%></td>
        <td><%= users.get(i).getAge()%></td>
        <td>
          <a href="./users/update/<%= users.get(i).getId()%>">修改</a>
        </td>
        <td>
          <a type="button" class="deleteUser" data-id="<%= users.get(i).getId()%>">删除</a>
        </td>
      </tr>
      <%
        }
      %>
    </table>

    <div>
      <a type="button" href="./users/creation">添加新用户</a>
    </div>

  </div>
</body>
</html>
