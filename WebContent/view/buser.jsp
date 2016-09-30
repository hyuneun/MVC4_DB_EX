<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr><th>부서번호</th><th>부서명</th><th>부서전화</th></tr>
	<c:forEach var="s" items="${data }">
	<tr>
		<td>${s.buser_no }</td>
		<td><a href="sawon.do?buser=${s.buser_name }">${s.buser_name }</a></td>
		<td>${s.buser_tel }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>