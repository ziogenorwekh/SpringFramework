<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>유저 정보</title>
</head>
<body>
<%@ include file="top.jsp"%>
<div>이름 : ${user.name}</div>
<div>이메일 : ${user.email}</div>
<hr>
<form method="post" action="/viewUser">
    <div>
    이름 : <input name="name" type="text" value="${user.name}"><br>
    이메일 : <input name="email" type="email" value="${user.email}"><br>
    </div>
    <input type="submit" value="변경">
</form>

<form method="post" action="/viewUserOnlyEmail">
    <div>
        이메일 : <input name="email" type="email" value="${user.email}">
    </div>
    <input type="submit" value="이메일만 변경">
</form>

<a href="/">돌아가기</a>
</body>
</html>
