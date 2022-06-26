<%--
  Created by IntelliJ IDEA.
  User: LSEK
  Date: 2022-06-10
  Time: 오후 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <style>
        .loginForm {
            text-align: center;
        }

        .input-box {
            position: relative;
            margin: 10px 0;
        }

        .input-box > input {
            background: transparent;
            border: none;
            border-bottom: solid 1px #ccc;
            padding: 20px 0px 5px 0px;
            font-size: 14pt;
            width: 100%;
        }

        input::placeholder {
            color: transparent;
        }

        input::placeholder {
            color: transparent;
        }

        input:placeholder-shown + label {
            color: #aaa;
            font-size: 14pt;
            top: 15px;
        }

        input:focus + label, label {
            color: #8aa1a1;
            font-size: 10pt;
            pointer-events: none;
            position: absolute;
            left: 0px;
            top: 0px;
            transition: all 0.2s ease;
            -webkit-transition: all 0.2s ease;
            -moz-transition: all 0.2s ease;
            -o-transition: all 0.2s ease;
        }

        input:focus, input:not(:placeholder-shown) {
            border-bottom: solid 1px #8aa1a1;
            outline: none;
        }

        .signUp {
            margin-top: 20px;
            width: 100%;
            font-size: 20px;
        }
    </style>
</head>
<body>


<div class="loginForm">
    <form method="post" action="../signUp">
        <div class="input-box">
            <input type="text" name="name" id="name" value="${userInfo.name}" placeholder="id">
            <label for="name">아이디</label>
        </div>
        <div class="input-box">
            <input type="email" name="email" id="email" value="${userInfo.email}" placeholder="email">
            <label for="email">이메일</label>
        </div>
        <br><br>
        <button class="signUp" type="submit">회원가입</button>
    </form>
</div>
<div>
    <span style="color: red">
        ${message}
    </span>
</div>
<div><a href="/">돌아가기</a></div>
</body>
</html>
