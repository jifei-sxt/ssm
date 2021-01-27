<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表页面</title>
</head>
<body>
	<h2>员工列表</h2>
	<hr>
	<c:if test="${not empty empList}">
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>员工编号</th>
					<th>上司编号</th>
					<th>员工姓名</th>
					<th>职位</th>
					<th>薪水</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="emp" varStatus="e">
					<tr>
						<td>${e.index}</td>
						<td>${emp.employeeId}</td>
						<td>${emp.managerId}</td>
						<td>${emp.firstName}-${emp.lastName}</td>
						<td>${emp.title}</td>
						<td>${emp.salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<hr>
</body>
</html>