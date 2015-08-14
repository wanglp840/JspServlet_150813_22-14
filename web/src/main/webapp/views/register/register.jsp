<%@ page contentType="text/html;charset=UTF-8" %>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>

<html>
<body>


请输入注册信息：
<form action="/register.do" method="POST">

    用户名
    <input name="username">
    密码
    <input name="password"/>
    <button type="submit">
        提交
    </button>
</form>

<br>
<a href="/views/login/login.jsp"> 去登录页 </a>


</body>
</html>