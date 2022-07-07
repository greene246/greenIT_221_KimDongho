<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="board.css">
<title>BOARD WRITER</title>
</head>
<body>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<form method="post" action="_06_boardWriterFormPro.jsp">
			<input type="text" name="title" id="title" placeholder="title" required>
			<textarea name="contents" placeholder="contents text" required></textarea><br>
			<input type="button" value="뒤로가기" onclick="location.href='_05_board.jsp'">
			<input type="submit" value="글쓰기">
		</form>
	</div>
</body>
</html>