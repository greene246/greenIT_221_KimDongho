<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARDWRITERPRO</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	//int userCode = Integer.parseInt((String) session.getAttribute("log"));
	
	BoardDTO board = new BoardDTO(title, contents);
	
	BoardDAO dao = BoardDAO.getInstance();
	
	String url = "";
	
	dao.addBoard(board);
	
	%>
</body>
</html>