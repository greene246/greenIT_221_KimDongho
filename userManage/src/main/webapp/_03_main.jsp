<%@page import="user.UserDAO"%>
<%@page import="user.UserDTO"%>
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
Object log = session.getAttribute("log");

out.print("로그값"+log);

if(log == null){
	response.sendRedirect("_00.index.jsp");
}
else{
	UserDAO dao = UserDAO.getInstance();
	UserDTO logInUser = dao.getUser((Integer) log);
	%>
	<h1><%=logInUser.getId()%>님 환영합니다.</h1>
	
	<button onclick="location.href='_05_board.jsp'">게시판</button>
	<button onclick="location.href='_04_logoutPro.jsp'">로그아웃</button>
<%
}

%>
</body>
</html>