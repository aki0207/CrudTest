<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/crud/create"
			method="post" modelAttribute="form">
			<h3>アドレスを入力してください</h3>
			<form:input path="mailAddress" />
			<form:errors path="mailAddress" cssClass="text-error" />
			
			<h3>パスワードを入力してください</h3>
			<form:input path="password" />
			<form:errors path="password" cssClass="text-error" />
			<form:button>登録!</form:button>
	</form:form>
	<div id="crudList">
		<ul>
			<c:forEach items="${cruds}" var="crud">
            	${f:h(crud.password)}
			</c:forEach>
		</ul>
	</div>

</body>
</html>