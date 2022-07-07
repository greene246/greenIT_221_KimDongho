<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARDUPDATEFORMPRO</title>
</head>
<body>
<%

	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	// 게시글의 코드
	int code = Integer.parseInt(request.getParameter("code"));
	
	BoardDAO dao = BoardDAO.getInstance();
	
	BoardDTO temp = new BoardDTO(code, title, contents);
	
	dao.update(temp);
	
	response.sendRedirect("_07_boardView.jsp?code="+code);
%>
</body>
</html>