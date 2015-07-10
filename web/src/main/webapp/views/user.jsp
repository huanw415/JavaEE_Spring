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
</head>
<body>
  <table  border=1 cellpadding=5>
    <tr>
      <th>姓名</th>
      <th>性别</th>
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
      <td><%= users.get(i).getEmail()%></td>
      <td><%= users.get(i).getAge()%></td>
      <td>
          <a href="/web/views/update?id=<%= users.get(i).getId()%>">修改</a>
      </td>
      <td>
          <a href="./userDelete?id=<%= users.get(i).getId()%>">删除</a>
      </td>
    </tr>
    <%
      }
    %>
  </table>

  <a type="button" href="./userCreation">添加新用户</a>

</body>
</html>
