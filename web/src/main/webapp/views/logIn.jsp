<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/12/15
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="./lib/css/bootstrap.css" rel="stylesheet"/>
  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <script src="./lib/js/bootstrap.min.js"></script>
  <title>用户登录</title>
</head>
<body>
  <div class="container">
    <form name="log_in" method="post" action="">
      <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
      </div>
      <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>

      <button type="submit" class="btn btn-default">提交</button>
      <button type="reset" class="btn btn-default">清空</button>
    </form>
  </div>
</body>
</html>
