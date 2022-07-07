<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
<title>BOARD</title>
</head>
<body>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<table border="1">
			<thead>	
				<tr>
					<th>no</th>
					<th>code</th>
					<th>title</th>
					<th>viewCnt</th>
					<th>likeCnt</th>
					<th>createdAt</th>
					<th>modifinedAt</th>
				</tr>
			</thead>
			<tbody>
			<%
			BoardDAO dao = BoardDAO.getInstance();
			
			ArrayList<BoardDTO> boards = dao.getBoard();
			
			for(int i=0; i<boards.size(); i++){
				String modify = "";
				BoardDTO board = boards.get(i);
				if(board.getModifiedAt() != null){
					modify = board.getModifiedAt().toString();
				}
				%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=board.getCode() %></td>
					<td><a href="_07_boardView.jsp?code=<%=board.getCode()%>"><%=board.getTitle()%></a></td>
					<td><%=board.getViewCnt()%></td>
					<td><%=board.getLikeCnt() %></td>
					<td><%=board.getCreatedAt() %></td>
					<td><%=modify %></td>
				</tr>
				<%
			}
				%>
			</tbody>
		</table>
		<input type="button" name="back" id="back" value="뒤로가기" onclick="location.href='_03_main.jsp'">
        <input type="button" name="write" id="write" value="글쓰기" onclick="location.href='_06_boardWriterForm.jsp'">
	</div>
</body>
</html>