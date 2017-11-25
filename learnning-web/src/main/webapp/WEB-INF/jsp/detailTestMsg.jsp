<%--
  Created by IntelliJ IDEA.
  User: wangsm
  Date: 2017/11/25
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DetailTestMsg Page</title>
</head>
<body>
<span>Bean Detail Message!</span>
<br/>
<table>


    <tr>
        <td>UserName:</td><td>${msgTest.username}</td>
    </tr>

    <tr>
        <td>Hello:</td><td>${msgTest.hello}</td>
    </tr>

    <tr>
        <td>Greeting:</td><td>${msgTest.greeting}</td>
    </tr>

    <tr>
        <td>Desc:</td><td>${msgTest.discription}</td>
    </tr>



</table>
</body>
</html>
