<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/crud/login"
			method="post" modelAttribute="form">
			<h3>アドレスを入力してください</h3>
			<form:input path="mailAddress" />
			<form:errors path="mailAddress" cssClass="text-error" />
			
			<h3>パスワードを入力してください</h3>
			<form:input path="password" />
			<form:errors path="password" cssClass="text-error" />
			<form:button>ログイン!</form:button>
	</form:form>
	
	<a href="${pageContext.request.contextPath}/crud/list">登録画面へ</a>
	
</body>
</html>