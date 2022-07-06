<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>LOG_IN</title>
</head>
<body>
    <h1>GREEN</h1>
    <form method="post" action="_00_loginPro.jsp">
        <div class="container">
            <input type="text" name="id" id="id" placeholder="id"><br>
            <input type="text" name="pw" id="pw" placeholder="password"><br>
            <span class="warning"><br>id / pw 를 입력해주세요</span><br>
            <input type="button" name="join" id="join" value="회원가입" onclick="location.href='_01_agree.jsp'">
            <input type="button" name="login" id="login" value="로그인" onclick="checkLogVal(form)">
        </div>
    </form>
    <script src="index.js"></script>
</body>
</html>