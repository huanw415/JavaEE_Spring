<%@ page import="com.tw.entity.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/19/15
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加新职员</title>

  <link href="../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../lib/js/bootstrap.min.js"></script>
  <script src="../js/createEmployee.js"></script>

</head>
<body>
  <div class="container">

    <form name="new_employee">
      <div class="row">
        <div class="col-md-offset-4 col-lg-4">
          <h3>修改用户信息</h3>
          <hr />
          <div class="form-group">
            <label for="employeeName">姓名</label>
            <input type="text" class="form-control" id="employeeName" name="employeeName" placeholder="姓名">
          </div>

          <div class="from-group">
            <label id="role">职位</label>
            <label for="OPs">
              <input type="radio" id="OPs" name="role" value="OPs"> OPs
            </label>
            <label for="coach">
              <input type="radio" id="coach" name="role" value="Coach"> Coach
            </label>
            <label for="HR">
              <input type="radio" id="HR" name="role" value="HR"> HR
            </label>
          </div>

          <div class="form-group">

            <label for="dropdown">用户名：</label>
            <div class="dropdown" id ="dropdown">
              <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                选择用户名
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <%
                  List<User> users = (List<User>)request.getAttribute("users");

                  for(int i=0; i<users.size(); i++){
                %>
                <li>
                  <a type="button" class="chooseUser" data-id="<%= users.get(i).getId()%>" data-name="<%= users.get(i).getName()%>"><%= users.get(i).getName()%></a>
                </li>
                <%
                  }
                %>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-offset-5">
        <a type="button" class="btn btn-default submit">提交</a>
        <button type="reset" class="btn btn-default">清空</button>
      </div>
    </form>
  </div>

</body>
</html>
