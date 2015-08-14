<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<% String courseId = request.getParameter("courseId"); %>
<% String courseName = request.getParameter("courseName"); %>
courseId:<%= request.getParameter("courseId")%>
userId:<%= request.getParameter("userId")%>
<br>
编辑课程：
<form action="/UserInfo.do?method=edit&courseIdd2=<%= request.getParameter("courseId")%>&userId=<%= request.getParameter("userId")%> "
      method="POST">
    课程名
    <input name="courseName" value="<%= request.getParameter("courseName")%>">
    <button type="submit">
        提交
    </button>
    <br>

</form>

</body>
</html>