<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>리스트</title>
    <style>
        .grid {
            display: grid;
            grid-template-columns: repeat(3, auto);
        }
    </style>
</head>
<body>
<%@ include file="top.jsp"%>
<div class="grid">
    <div>아이디</div>
    <div>이름</div>
    <div>이메일</div>
    <c:forEach var="user" items="${userList}">
        <div>${user.id}</div>
        <div><a href="/viewUser?id=${user.id}">${user.name}</a></div>
        <div>${user.email}</div>
    </c:forEach>
</div>

</body>
</html>