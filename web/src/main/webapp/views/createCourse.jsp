<%@ page import="com.tw.entity.Employee" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/20/15
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>

  <link href="../lib/css/bootstrap.css" rel="stylesheet"/>

  <script src="../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../lib/js/bootstrap.min.js"></script>
  <script src="../js/createCourse.js"></script>
</head>
<body>
  <div class="container">
    <form id="new_course" name="new_schedule">
      <div class="row">
        <div class="col-md-offset-4 col-lg-4">
          <h3>添加课程</h3>
          <hr />
          <div class="form-group">
            <label>课程名称:</label>
            <div>
              <label for="courseName">
                <input type="text" id="courseName" name="courseName">
              </label>
            </div>
          </div>
          <div class="from-group">
            <label>教练</label>
            <%
              List<Employee> employeeList = (List<Employee>) request.getAttribute("coaches");
              for(int i=0; i<employeeList.size(); i++){
            %>
              <div>
                <label for="<%= employeeList.get(i).getId()%>">
                  <input type="radio" id="<%= employeeList.get(i).getId()%>" name="coachName" value="<%= employeeList.get(i).getName()%>"> <%= employeeList.get(i).getName()%>
                </label>
              </div>
            <%
              }
            %>
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
