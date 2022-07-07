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
	int userCode = (int) session.getAttribute("log");
	
	BoardDTO board = new BoardDTO(title, contents, userCode);
	
	BoardDAO dao = BoardDAO.getInstance();
	
	String url = "";
	
	if(dao.addBoard(board)){
		// 작성이 됐다면
		url = "_05_board.jsp";
	}
	else{
		// 작성이 실패했다면
		url = "_06_boardWriterForm.jsp";
	}
	
	response.sendRedirect(url);
	
	%>
</body>
</html>