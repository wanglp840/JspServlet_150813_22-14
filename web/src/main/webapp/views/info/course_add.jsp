<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<% String userId = request.getParameter("userId"); %>
userId:<%= request.getParameter("userId")%>
<br>
新增课程：
<form action="/UserInfo.do?method=add&userIdd=<%= request.getParameter("userId")%> " method="POST">
    课程名
    <input name="courseName">
    <button type="submit">
        提交
    </button>
    <br>


</form>

</body>
</html>