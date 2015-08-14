<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

<%! String name22 = "${loginName}"; %>
登陆成功, userId:${userId} 姓名：${loginName} <br>

sessionTest:<br>
SessionId:${pageContext.session.getId()}<br>
SessionAttribute:${pageContext.session.getAttribute("sessionIdTest")}<br>
SessionAttribute:${pageContext.session.getAttribute("sessionIdTest")}<br><br>

<table>
    <form action="/UserInfo.do" method="post">
        <tr>
            <td>课程id&nbsp;&nbsp;&nbsp;</td>
            <td>课程名称&nbsp;&nbsp;&nbsp;</td>
            &nbsp;
            <td>操作&nbsp;&nbsp;&nbsp;</td>

            <a href="/views/info/course_add.jsp?userId=${userId}"> 增加
            </a>

        </tr>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>
                    <form action="/UserInfo.do?method=del&userIdd=${userId}&courseId=${course.courseId}&userLoginName=${loginName}&userLoginName=${loginName}"
                          method="post">
                        <input type="hidden" name="userLoginName" value="${loginName}">
                            <%--${param.values().contains(loginName)}--%>
                        <button type="submit">del</button>
                        </button> </form>
                </td>
                <td>
                    <a href="/views/info/course_edit.jsp?userId=${userId}&courseId=${course.courseId}&courseName=${course.courseName}&userLoginName=${loginName}">编辑</a>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>