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
    <title></title>
  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <script src="./js/user.js"></script>
</head>
<body>
  <a type="button" href="./logout">退出登录</a>
  <table  border=1 cellpadding=5>
    <tr>
      <th>姓名</th>
      <th>性别</th>
      <th>密码</th>
      <th>邮箱</th>
      <th>年龄</th>
      <th>删除</th>
      <th>修改</th>
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
        <button id="deleteUser", data-id="<%= users.get(i).getId()%>">删除</button>
      </td>
    </tr>
    <%
      }
    %>
  </table>

  <a type="button" href="./users/creation">添加新用户</a>

</body>
</html>
