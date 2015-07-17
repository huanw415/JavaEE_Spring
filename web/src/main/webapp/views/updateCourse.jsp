<%@ page import="com.tw.entity.Course" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/17/15
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改课程信息</title>
  <link href="../../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../../lib/js/bootstrap.min.js"></script>
  <%--<script src="../../js/updateUser.js"></script>--%>
</head>
<body>
<div class="container">

  <form name="new_user" method="POST" action="">
    <div class="row">
      <div class="col-md-offset-4 col-lg-4">
        <h3>修改用户信息</h3>
        <hr />
        <div class="form-group">
          <label for="name">姓名：</label>
          <input type="text" class="form-control" id="name" name="name" placeholder="姓名" value="<%= ((Course)request.getAttribute("course")).getName()%>">
        </div>

        <%--<div class="from-group">--%>
          <%--<label id="gender" data-value="<%= ((Course)request.getAttribute("course")).getCoach()%>">性别</label>--%>
          <%--<label for="male">--%>
            <%--<input type="radio" id="male" name="gender" value=男> 男--%>
          <%--</label>--%>
          <%--<label for="female">--%>
            <%--<input type="radio" id="female" name="gender" value=女> 女--%>
          <%--</label>--%>
        <%--</div>--%>
        <div class="from-group">
          <label for="dropdown">教练：</label>
          <div class="dropdown" id ="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
              Dropdown
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
              <%--<% %>--%>
              <li>Action</li>
              <li>Another action</li>
              <li>Something else here</li>
            </ul>
          </div>
        </div>
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




