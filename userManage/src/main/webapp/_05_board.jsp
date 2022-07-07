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
			<%for(int i=0; i<10; i++){
				BoardDTO board = new BoardDTO();
			}
				%>
				<tr>
					<td><%=no %></td>
					<td><%=code %></td>
					<td><%=title %></td>
					<td><%=viewCnt %></td>
					<td><%=likeCnt %></td>
					<td><%=createdAt %></td>
					<td><%=modifiedAt %></td>
				</tr>
				<%
				%>
			</tbody>
		</table>
	</div>
</body>
</html>