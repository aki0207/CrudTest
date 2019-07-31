<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="todoList">
		<ul>
			<c:forEach items="${cruds}" var="crud">
            	${f:h(crud.password)}
			</c:forEach>
		</ul>
	</div>

</body>
</html>