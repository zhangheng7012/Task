<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>

<%--<div style="width:500px;margin:0px auto;text-align:center">

    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="/students">
            <h3>添加</h3>
            创建时间：<input name="createAt" type="text"><br/>
            更新时间：<input name="updateAt" type="text"><br/>
            姓名：   <input name="name" type="text"><br/>
            QQ：     <input name="qq" type="text"><br/>
            工作类型：<input name="job" type="text"><br/>
            入学日期：<input name="date" type="text"><br/>
            毕业院校：<input name="school" type="text"><br/>
            线上学号：<input name="onlineNum" type="text"><br/>
            日报链接：<input name="daily" type="text"><br/>
            入学誓言：<input name="dream" type="text"><br/>
            辅导师兄：<input name="brother" type="text"><br/>
            从哪得知修真院：<input name="knowHow" type="text"><br/>
            <br><br>
            <input type="submit" value="添加">
        </form>
    </div>
</div>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    --%>
    <title>localhost</title>
</head>
<body>
<sf:form action="/students" method="POST" modelAttribute="student">
    <table>
        <TR>
            <td>
                <fmt:message key="xzy_student.createAt"/>：
            </td>
            <td>
                <INPUT name="createAt" value="${student.createAt}">
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.updateAt"/>：
            </td>
            <td>
                <INPUT name="updateAt" value="${student.updateAt}">
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.name"/>：
            </td>
            <td>
                <INPUT name="name" value="${student.name}">
            </td>
            <td>
                <sf:errors path="name" cssStyle="color:red"></sf:errors>
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.qq"/>：
            </td>
            <td>
                <INPUT name="qq" value="${student.qq}">
            </td>
            <td>
                <sf:errors path="qq" cssStyle="color:red"></sf:errors>
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.job"/>：
            </td>
            <td>
                <INPUT name="job" value="${student.job}">
            </td>
            <td>
                <sf:errors path="job" cssStyle="color:red"></sf:errors>
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.date"/>：
            </td>
            <td>
                <INPUT name="date" value="${student.date}">
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.school"/>：
            </td>
            <td>
                <INPUT name="school" value="${student.school}">
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.onlineNum"/>：
            </td>
            <td>
                <INPUT name="onlineNum" value="${student.onlineNum}">
            </td>
        </TR>
        <TR>
        <td>
            <fmt:message key="xzy_student.daily"/>：
        </td>
        <td>
            <INPUT name="daily" value="${student.daily}">
        </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.dream"/>：
            </td>
            <td>
                <INPUT name="dream" value="${student.dream}">
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.brother"/>：
            </td>
            <td>
                <INPUT name="brother" value="${student.brother}">
            </td>
        </TR>
        <TR>
            <td>
                <fmt:message key="xzy_student.knowHow"/>：
            </td>
            <td>
                <INPUT name="knowHow" value="${student.knowHow}">
            </td>
        </TR>

        <tr>
            <td>
                <fmt:message key="springmvc.language"/>：
            </td>
            <td>
                <a href="/students/student?locale=zh_CN">中文</a>
                <a href="/students/student?locale=en_US">English</a><br/>
            </td>
            <td>
                <fmt:message key="springmvc.now.language"/>：${pageContext.response.locale}
            </td>
        </tr>

        <tr>
            <td>
                    <%--
                                        <INPUT input type="submit" value="添加">
                    --%>
                <INPUT input type="submit" value="<fmt:message key="springmvc.submit"/>">

            </td>
        </tr>

    </table>
</sf:form>
</body>
</html>

<%--<div style="width:500px;margin:0px auto;text-align:center">

    <div style="text-align:center;margin-top:40px">

        <form method="post" action="/addCategory">
            名称： <input name="name"type="text"> <br><br/>
            qq： <input name="qq"type="text"> <br><br/>
            学校： <input name="school"type="text"> <br><br/>
            <input type="submit" value="添加">
        </form>
        <!-- 显示错误信息 -->
        <c:if test="${allErrors != null }">
            <c:forEach items="${allErrors}" var="error">
                <font color="red" >${error.defaultMessage}</font>
            </c:forEach>
        </c:if>
    </div>
</div>--%>
