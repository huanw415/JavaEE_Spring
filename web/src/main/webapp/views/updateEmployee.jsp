<%@ page import="com.tw.entity.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/19/15
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改职员信息</title>

  <link href="../../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../../lib/js/bootstrap.min.js"></script>
  <script src="../../js/updateEmployee.js"></script>
</head>
<body>
  <div class="container">

    <form name="new_user" method="POST" action="">
      <div class="row">
        <div class="col-md-offset-4 col-lg-4">
          <h3>修改用户信息</h3>
          <hr />
          <div class="form-group">
            <label for="employeeName">姓名</label>
            <input type="text" class="form-control" id="employeeName" name="employeeName" placeholder="姓名" value="<%= ((Employee)request.getAttribute("employee")).getName()%>">
          </div>

          <div class="from-group">
            <label id="role" data-value="<%= ((Employee)request.getAttribute("employee")).getRole()%>">职位</label>
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

          <%--<div class="form-group">--%>
            <%--<label for="name">用户名</label>--%>
            <%--<input type="text" class="form-control" id="name" name="name" placeholder="用户名" value="<%= ((Employee) request.getAttribute("employee")).getUser().getName()%>">--%>
          <%--</div>--%>

          <%--<div class="from-group">--%>
            <%--<label id="gender" data-value="<%= ((Employee)request.getAttribute("employee")).getUser().getName()%>">性别</label>--%>
            <%--<label for="male">--%>
              <%--<input type="radio" id="male" name="gender" value="男"> 男--%>
            <%--</label>--%>
            <%--<label for="female">--%>
              <%--<input type="radio" id="female" name="gender" value="女"> 女--%>
            <%--</label>--%>
          <%--</div>--%>

          <%--<div class="form-group">--%>
            <%--<label for="email">邮箱</label>--%>
            <%--<input type="email" class="form-control" id="email" name="email" placeholder="邮箱" value="<%= ((Employee)request.getAttribute("employee")).getUser().getEmail()%>">--%>
          <%--</div>--%>

          <%--<div class="form-group">--%>
            <%--<label for="age">年龄</label>--%>
            <%--<input type="text" class="form-control" id="age" name="age" placeholder="年龄" value="<%= ((Employee)request.getAttribute("employee")).getUser().getAge()%>">--%>
          <%--</div>--%>

          <div class="col-md-offset-5">
            <button type="submit" class="btn btn-default">提交</button>
            <button type="reset" class="btn btn-default">清空</button>
          </div>
        </div>
      </div>
    </form>
  </div>
</body>
</html>
