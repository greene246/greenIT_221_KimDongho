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
<title>BOARDUPDATEFORM</title>
</head>
<body>
<%
	BoardDAO dao = BoardDAO.getInstance();

	BoardDTO posting = dao.getBoard(Integer.parseInt(request.getParameter("code")));

%>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<form action="_08_boardUpdateFormPro.jsp">
			<input type="text" name="title" id="title" value="<%=posting.getTitle()%>"required>
			<textarea name="contents" required><%=posting.getContents()%></textarea><br>
			<%
			
			%>
			<input type="hidden" name="code" value="<%=posting.getCode()%>">
			<input type="button" value="뒤로가기" onclick="location.href='_07_boardView.jsp'">
			<input type="submit" value="저장하기">
		</form>
	</div>
</body>
<script src="index.js"></script>
</html>