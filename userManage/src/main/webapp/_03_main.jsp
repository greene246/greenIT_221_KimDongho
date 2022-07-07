<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="index.css">
<title>MAIN</title>
</head>
<body>
	<h1>GREEN</h1>
<%
String log = (String) session.getAttribute("log");

if(log == null){
	response.sendRedirect("_00.index.jsp");
}
else{%>
	<h1><%=log %>님 환영합니다.</h1>
	
	<button onclick="location.href='_05_board.jsp'">게시판</button>
	<button onclick="location.href='_04_logoutPro.jsp'">로그아웃</button>
<%
}

%>
</body>
</html>