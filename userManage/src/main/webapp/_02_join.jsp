<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>JOIN</title>
</head>
<body>
    <h1>GREEN</h1>
    <form method="post" action="_02_joinPro.jsp">
        <div class="contents">
            <input class="req" type="text" name="id" placeholder="id">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            <div>
                <input class="req" type="password" name="pw" placeholder="password">
            <span class="warning"><br>필수값 입력 바랍니다.</span><br>
                <input class="req" type="password" name="pw" placeholder="password">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            </div>
            <input class="req" type="text" name="name" placeholder="name">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            <div>
                <input class="req" type="text" name="year" pattern="[0-9]{4}" placeholder="생년" title="#### 출생년도 4자리를 입력해주세요.">
                <input class="req" type="number" name="month" min="1" max="12" placeholder="월">
                <input class="req" type="number" name="day" min="1" max="31" placeholder="일">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            </div>
            <select name="gender">
                <option value="none">성별</option>
                <option value="man">남</option>
                <option value="woman">여</option>
            </select>
            <input class="req" type="email" name="email" placeholder="email">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            <div>
                <select name="country">
                    <option value="kor">대한민국 +82</option>
                </select>
                <input class="req" type="text" id="mobile" name="mobile" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="000-0000-0000" title="###-####-####">
                <input type="button" value="인증" onclick="checkMobile(form)">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            </div>
        </div>

        <div class="buttons">
            <input type="button" value="뒤로" onclick="location.href = '_01_agree.jsp'">
            <input type="button" value="확인" onclick="checkJoinVal(form)">
        </div>
    </form>
    <script src="index.js"></script>
</body>
</html>