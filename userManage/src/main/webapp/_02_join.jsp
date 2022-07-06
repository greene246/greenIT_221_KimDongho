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
    <form>
        <div class="contents">
            <input class="req" type="text" placeholder="id">
            <span class="warning"><br>필수값 입력 바랍니다.</span>
            <div>
                <input class="req" type="password" placeholder="password">
                <input class="req" type="password" placeholder="password">
            </div>
            <input class="req" type="text" placeholder="name">
            <div>
                <input class="req" type="text" pattern="[0-9]{4}" placeholder="생년" title="#### 출생년도 4자리를 입력해주세요.">
                <input class="req" type="number" min="1" max="12" placeholder="월">
                <input class="req" type="number" min="1" max="31" placeholder="일">
            </div>
            <select>
                <option value="none">성별</option>
                <option value="man">남</option>
                <option value="woman">여</option>
            </select>
            <input class="req" type="email" placeholder="email">
            <div>
                <select>
                    <option value="kor">대한민국 +82</option>
                </select>
                <input class="req" type="text" id="mobile" name="mobile" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="mobile" title="###-####-####">
                <input type="button" value="인증" onclick="checkMobile(form)">
            </div>
        </div>

        <div class="buttons">
            <input type="button" value="뒤로" onclick="location.href = 'form_agree.html'">
            <input type="button" value="확인" onclick="checkJoinVal(form)">
        </div>
    </form>

    <script src="validation.js"></script>
</body>
</html>