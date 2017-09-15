<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${page==null || page.numberOfElements==0 }">
	nothing any more
</c:if>
	<c:if test="${page!=null && page.numberOfElements>0 }">
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
			<c:forEach items="${page.content}" var="user">
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
			<tr>
				<td colspan="8">
					共 ${page.totalElements } 条记录
					共 ${page.totalPages } 页
					当前 ${page.number + 1 } 页
					<a href="?pageNumberStr=${page.number + 1 - 1 }">上一页</a>
					<a href="?pageNumberStr=${page.number + 1 + 1 }">下一页</a>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>