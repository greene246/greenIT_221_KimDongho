<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="board.css">
<title>BOARD CONTENTS</title>
</head>
<body>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<form>
			<input type="text" name="title" id="title" value="<%=%>"
				required readonly>
			<textarea name="contens" required readonly><%=%></textarea>
			<br> <input type="button" value="뒤로가기"> <input
				type="button" value="수정하기">
		</form>
	</div>
</body>
</html>