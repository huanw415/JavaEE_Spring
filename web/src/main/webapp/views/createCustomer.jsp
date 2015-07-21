<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/21/15
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加顾客</title>
  <link href="../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../lib/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form name="new_customer" method="POST" action="">
    <div class="row">
      <div class="col-md-offset-4 col-lg-4">
        <h3>添加新顾客</h3>
        <hr />
        <div class="form-group">
          <label for="name">姓名</label>
          <input type="text" class="form-control" id="name" name="customerName" placeholder="姓名">
        </div>
        <div class="col-md-offset-5">
          <button type="submit" class="btn btn-default">提交</button>
          <a type="button" class="btn btn-default" href="/web/customers">返回</a>
          <button type="reset" class="btn btn-default">清空</button>
        </div>
      </div>
    </div>
  </form>
</div>

</body>
</html>
