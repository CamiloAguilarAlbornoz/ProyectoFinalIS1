<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de agentes</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th colspan="5">Lista de agentes</th>
			</tr>
			<tr>
				<th>Documento</th>
				<th>Nombres</th>
				<th>Apellidos</th>
				<th>Direccion</th>
				<th>Estado</th>
				<c:forEach items="${listAgent}" var="agent">
					<tr>
						<td><c:out value="${agent.document}"></c:out></td>
						<td><c:out value="${agent.name}"></c:out></td>
						<td><c:out value="${agent.lastName}"></c:out></td>
						<td><c:out value="${agent.direction}"></c:out></td>
						<td><c:out value="${agent.state}"></c:out></td>
					</tr>
				</c:forEach>
		</table>
		<a href="controlAgent.jsp">Volver</a>
	</body>
</html>