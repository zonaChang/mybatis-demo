<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
<title>学生信息</title>
</head>
<body>
<c:choose>
<c:when test="${errNo eq 0}">
	<ul class="info_container">
	    <c:forEach var="student" items="${studentBeans }">
	        <li class="info_list" id="student${student.id }"><a href="${pageContext.request.contextPath}/api/student/queryStudentById?id=${student.id }">${student.name }</a></li>
	    </c:forEach>
    </ul>
</c:when>
<c:otherwise>
    <p class="warn tip">${errInfo }</p>
</c:otherwise>
</c:choose>
</body>
</html>