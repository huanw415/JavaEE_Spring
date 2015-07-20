<%@ page import="com.tw.entity.Schedule" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/20/15
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改课程表</title>
  <link href="../../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../../lib/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">

    <form name="update_schedule" method="POST" action="">
      <div class="row">
        <div class="col-md-offset-4 col-lg-4">
          <h3>修改用户信息</h3>
          <hr />
          <div class="form-group">
            <label for="courseName">课程名称：</label>
            <input type="text" class="form-control" id="CourseName" name="courseName" value="<%= ((Schedule)request.getAttribute("schedule")).getCourse().getName()%>" disabled>
          </div>

          <div class="form-group">
            <label for="coachName">教师：</label>
            <input type="text" class="form-control" id="coachName" name="coachName" value="<%= ((Schedule)request.getAttribute("schedule")).getCourse().getEmployee().getName()%>" disabled>
          </div>

          <div class="from-group">
            <label for="time">时间：</label>
            <input type="date" class="form-control" id="time" name="time" value="<%= ((Schedule)request.getAttribute("schedule")).getTime().toString().substring(0, 10)%>" >
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
