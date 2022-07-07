<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
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
<%
	BoardDAO dao = BoardDAO.getInstance();

	BoardDTO posting = dao.getBoard(Integer.parseInt(request.getParameter("code")));

%>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<form>
			<input type="text" name="title" id="title" value="<%=posting.getTitle()%>"required readonly>
			<textarea name="contens" required readonly><%=posting.getContents()%></textarea><br>
			<%
			
			%>
			<input type="button" value="뒤로가기" onclick="location.href='_05_board.jsp'">
			<input type="button" value="수정하기" onclick="location.href='_08_boardUpdateForm.jsp?code=<%=posting.getCode()%>'">
		</form>
	</div>
</body>
<script src="index.js"></script>
</html>