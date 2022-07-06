<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOINPRO</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	// response.setCharacterEncoding("utf-8");
	
	
	// 전달된 파라미터 값 가져오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int year =  Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int day = Integer.parseInt(request.getParameter("day"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	String mobile = request.getParameter("mobile");
	
	// UserDAO를 통해 addUser(UserDTO userDto);
	
	// ***접근할 권한 부여***
	UserDAO dao = UserDAO.getInstance();
	
	// UserDTO user = new UserDTO(name);
	// dao.addUser(user);
	
	// ***값을 받아와서 유저 추가***
	UserDTO user = new UserDTO(id, pw, name, year, month, day, gender, email, country, mobile);
	
	// UserDAO를 통해 getUser
	// UserDTO reulst = dao.getUser(name);
	
	// 파라미터 값을 식별하고,
	// ㄴ다음 로직에 대한 처리를 분리할 수 있음
	String url = "";
	if(dao.userDupl(user)){
		url = "_03_Main.jsp";
	}
	else{
		url = "_00_login.jsp";
	}
	
	// 1. 단순 페이지 이동
	// http://localhost:8081/webProject/test1.jsp
	// response.sendRedirect(url);
	
	// 2. 디스패처를 활용한 포워딩
	// http://localhost:8081/webProject/indexPro.jsp?name=
	request.getRequestDispatcher(url).forward(request, response);
	%>
</body>
</html>