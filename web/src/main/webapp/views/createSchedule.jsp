<%@ page import="java.util.List" %>
<%@ page import="com.tw.entity.Course" %>
<%@ page import="org.w3c.dom.ls.LSException" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/20/15
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加课表</title>

  <link href="../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../lib/js/bootstrap.min.js"></script>
  <script src="../js/createSchedule.js"></script>
</head>
<body>
<div class="container">

  <form id="new_schedule" name="new_schedule">
    <div class="row">
      <div class="col-md-offset-4 col-lg-4">
        <h3>添加课程表</h3>
        <hr />
        <div class="form-group">
          <div><label>课程名称:</label></div>
          <%
            List<Course> courses = (List<Course> )request.getAttribute("courses");
            for(int i=0; i<courses.size(); i++){
          %>

          <div>
            <label for="<%= courses.get(i).getName() %>">
                <input type="radio" id="<%= courses.get(i).getName() %>" name="courseId" value="<%= courses.get(i).getId() %>"> <%= courses.get(i).getName() %>&nbsp;&nbsp;<%= courses.get(i).getEmployee().getName() %>
            </label>
          </div>
          <%
            }
          %>
        </div>

        <div class="from-group">
          <label for="time">时间：</label>
          <input type="date" class="form-control" id="time" name="time">
        </div>

      </div>
    </div>
    <div class="col-md-offset-5">
      <button type="submit" class="btn btn-default">提交</button>
      <button type="reset" class="btn btn-default">清空</button>
    </div>
  </form>
</div>
</body>
</html>