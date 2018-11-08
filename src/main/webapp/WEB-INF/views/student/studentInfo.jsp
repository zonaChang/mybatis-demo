<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<table class="tip">
    <caption class="title">${result.name }的个人信息：</caption>
    <tr>
        <th>班级</th><th>教师</th>
    </tr>
    <c:choose>
        <c:when test="${result.errNo eq 0 }">
	        <tr>
	            <td>${result.students.clazz.name }</td>
	              <td> 
		            <c:forEach var="teacher" items="${result.students.teachers }" varStatus="status">
		                 <c:choose>
		                     <c:when test="${status.last }">
		                       ${teacher.name }
		                     </c:when>
		                     <c:otherwise>
		                      ${teacher.name },
		                     </c:otherwise>
		                 </c:choose>
		            </c:forEach>
	              </td>
            </tr>
        </c:when>
        <c:otherwise>
        <tr>
            <td colspan="2">${result.errInfo }</td>
        </tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>