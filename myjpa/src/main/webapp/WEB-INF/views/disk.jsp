<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hardInfo</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/jquery-3.2.1.min.js"></script>
<script>
	$().ready(
		function() {
			$("#go").click(
				$.ajax({
					url : "disk",
					type : "get",
					timeout : 1000,
					cache : false,
					async : true,
					
					success : successfunction(data),
					error : errorFunction
				}),
					function successFunction(data) {
					var html = "";
					for (var i = 0; i < data.length; i++) {
						var ls = data[i];
						html += "<span>" + ls.user > +"</span>"
							+ "<span>" + ls.Sys + "</span>"
							+ "<span>" + ls.wait + "</span>"
							+ "<span>" + ls.nice + "</span>"
							+ "<span>" + ls.idle + "</span>"
							+ "<span>" + ls.total + "</span>";
					}
					$("#ulul").html(html);

				},
				function errorFunction() {
					alert("error")
				}
			)
		}
	)
</script>
</head>
<body>
	<div id="body">
		<input type="button" id="go" value="click">
		<h1>this is the hard page</h1>
		<div id="ulul"></div>
		<h3><font color="red">${mav}</font></h3>
	</div>
</body>
</html>