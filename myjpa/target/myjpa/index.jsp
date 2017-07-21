<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/echarts.min.js"></script>
<script type="text/javascript" src="resource/angular.min.js"></script>
<script type="text/javascript" src="resource/angular-animate.min.js"></script>
<script type="text/javascript" src="resource/angular-route.min.js"></script>
<script type="text/javascript" src="resource/js/app.js"></script>
</head>
<body ng-app="myApp">
	<h2>Hello World!</h2>
	<a href="#/login">登陆</a>
	<br>
	<a href="#/reg">注册</a>
	<br>
	<a href="#/cpu">CPU</a>
	<br>
	<a href="#/disk">DISK</a>
	<br>
	<a href="#/cpus">CPUS</a>
	<br>
	<a href="#/memory">MEMORY</a>
	<br>
	<a href="#/swap">SWAP</a>
	<br>

</body>
</html>
