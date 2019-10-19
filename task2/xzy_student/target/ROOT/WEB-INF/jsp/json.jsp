<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<json:object>
    <json:property name="id" value="${stu.id}"/>
    <json:property name="name" value="${stu.name}"/>
    <json:property name="qq" value="${stu.qq}"/>
    <json:property name="job" value="${stu.job}"/>
<%--    <json:array name="items" var="item" items="${cart.lineItems}">
        <json:object>
            <json:property name="title" value="${item.title}"/>
            <json:property name="description" value="${item.description}"/>
            <json:property name="imageUrl" value="${item.imageUrl"/>
            <json:property name="price" value="${item.price}"/>
            <json:property name="qty" value="${item.qty}"/>
        </json:object>
    </json:array>--%>
</json:object>

</body>
</html>
