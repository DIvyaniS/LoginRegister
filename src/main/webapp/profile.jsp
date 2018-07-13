<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

   User Name   : <c:out value="${out.getUsername()}"></c:out> <br/>
   Balance   : <c:out value="${out.getBalance()}"></c:out> <br/>
   Role   :  <c:out value="${role}"></c:out> <br/>
   <!--<c:forEach var="r" items="${role}">
    <c:out value="${r}"/> 
</c:forEach>
-->
</div>
<!-- /container -->
</body>
</html>