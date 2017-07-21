<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
	<mvc:form action="reg" method="post" modelAttribute="boardUser">
		name:<mvc:input path="userName" />
		<font color="red"><mvc:errors path="userName" /></font>
		<br>  
        password:<mvc:input path="userPassword" />
		<font color="red"><mvc:errors path="userPassword" /></font>
		<br>
		userAge:<mvc:input path="userAge" />
		<font color="red"><mvc:errors path="userAge" /></font>
		<br>
		userAddress:<mvc:input path="userAddress" />
		<font color="red"><mvc:errors path="userAddress" /></font>
		<br>
		userSex:<mvc:input path="userSex" />
		<font color="red"><mvc:errors path="userSex" /></font>
		<br>
		userRole:<mvc:input path="userRole" />
		<font color="red"><mvc:errors path="userRole" /></font>
		<br>
		userBirthday:<mvc:input path="userBirthday" />
		<font color="red"><mvc:errors path="userBirthday" /></font>
		<br>
		userEmail:<mvc:input path="userEmail" />
		<font color="red"><mvc:errors path="userEmail" /></font>
		<br>
		<input type="submit" value="注册">
	</mvc:form>
