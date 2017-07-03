<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All the user are below</title>
</head>
<body>
	<%-- <h1>登陆成功，欢迎:${userName}</h1> --%>
	<br>
	<h1>this is all the user</h1>
	:
	<br>
	<h3>${users}</h3>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>住址</th>
			<th>邮箱</th>
			<th>年纪</th>
			<th>生日</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.userSex}</td>
				<td>${user.userAddress}</td>
				<td>${user.userEmail}</td>
				<td><input type="text" value="${user.userAge}"
					readOnly="readonly"></td>
				<td><fmt:formatDate value="${user.userBirthday
						}"
						pattern="yyyy-MM-dd" /></td>
				<td><a href="findbyid/${user.userId}">编辑</a></td>
				<td><a href="delete/${user.userId}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>