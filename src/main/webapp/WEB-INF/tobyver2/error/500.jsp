<%--
  Created by IntelliJ IDEA.
  User: LSEK
  Date: 2022-06-22
  Time: 오후 4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
에러 500<br>
<span style="color: red">
    ${pageContext.exception.message}
</span>
</body>
</html>
