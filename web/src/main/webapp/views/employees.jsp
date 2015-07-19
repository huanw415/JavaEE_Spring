<%@ page import="com.tw.entity.Employee" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <link href="./lib/css/bootstrap.css" rel="stylesheet"/>

    <script src="./lib/js/jquery-1.11.1.min.js"></script>
    <script src="./js/user.js"></script>

    <script src="./lib/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="./index"> 首页 </a></li>
                    <li><a href="./users">用户管理</a> </li>
                    <li class="active"><a href="./employees">员工管理</a> </li>
                    <li><a href="./courses">课程管理</a> </li>
                    <li><a href="./customers">顾客管理</a> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a type="button" href="./logout">退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <caption><h2>职员信息表</h2></caption>
        <tr>
            <th>姓名</th>
            <th>职位</th>
            <th>用户名</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>年龄</th>
            <th>修改</th>
        </tr>
        <%
            List<Employee> employees = (List<Employee>)request.getAttribute("employees");

            for(int i=0; i<employees.size(); i++){
        %>
        <tr>
            <td><%= employees.get(i).getName()%></td>
            <td><%= employees.get(i).getRole()%></td>
            <td><%= employees.get(i).getUser().getName()%></td>
            <td><%= employees.get(i).getUser().getGender()%></td>
            <td><%= employees.get(i).getUser().getEmail()%></td>
            <td><%= employees.get(i).getUser().getAge()%></td>
            <td>
                <a href="./employees/update/<%= employees.get(i).getId()%>">修改</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <div>
        <a type="button" href="./users/creation">添加职员</a>
    </div>

</div>
</body>
</html>
