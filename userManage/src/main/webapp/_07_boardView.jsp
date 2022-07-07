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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="board.css">
<title>BOARD CONTENTS</title>
</head>
<body>
<%
	BoardDAO dao = BoardDAO.getInstance();

	BoardDTO posting = dao.getBoard(Integer.parseInt(request.getParameter("code")));
	
	int log = (int) session.getAttribute("log");
	
	out.print("로그값" + log);
	out.print("게시글의 코드" + posting.getUserCode());
	
	
	// 1. 세션에 로그갑이 없으면 00페이지로 강제이동
	
	// 2. 세션에 로그값을 가쟈와서 게시글의 유저코드와 비교
	
	// 3. 안맞으면 diplay : none       맞으면 display : block or inline-block
	
	// 4 $(.선택자).css('display', 'none')  $(.선택자).css('display', 'block')

%>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<form>
			<input type="text" name="title" id="title" value="<%=posting.getTitle()%>"required readonly>
			<textarea name="contens" required readonly><%=posting.getContents()%></textarea><br>
			<input type="button" value="뒤로가기" onclick="location.href='_05_board.jsp'">
			<%
				if(log == posting.getUserCode()){
					%>
						<input type="button" value="수정하기" onclick="location.href='_08_boardUpdateForm.jsp?code=<%=posting.getCode()%>'">
					<%
				}
			%> 
			
		</form>
	</div>
</body>
<script src="index.js"></script>
</html>