<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/8/15
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加新用户</title>

  <link href="../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../lib/js/bootstrap.min.js"></script>

</head>
<body>
  <div class="container">
    <form name="new_user" method="POST" action="">
      <div class="row">
        <div class="col-md-offset-4 col-lg-4">
          <h3>添加新用户</h3>
          <hr />
          <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
          </div>

          <div class="from-group">
            <label>性别</label>
            <label for="male">
              <input type="radio" id="male" name="gender" value=男> 男
            </label>
            <label for="female">
              <input type="radio" id="female" name="gender" value=女> 女
            </label>
          </div>

          <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
          </div>

          <div class="form-group">
            <label for="email">邮箱</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
          </div>

          <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="年龄">
          </div>

          <div class="col-md-offset-5">
            <button type="submit" class="btn btn-default">提交</button>
            <a type="button" class="btn btn-default" href="/web/users">返回</a>
            <button type="reset" class="btn btn-default">清空</button>
          </div>
        </div>
      </div>
    </form>
  </div>
</body>
</html>
