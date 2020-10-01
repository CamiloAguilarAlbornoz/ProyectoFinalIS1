<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de multas</title>
	</head>
	<body>
	<table border="1">
			<tr>
				<th colspan="9">Lista de multas</th>
			</tr>
			<tr>
				<th>ID Multa</th>
				<th>Fecha</th>
				<th>Descripcion</th>
				<th>Identificador conductor</th>
				<th>Nombre conductor</th>
				<th>Identificador agente</th>
				<th>Nombre agente</th>
				<th>Estado Multa</th>
				<th>Valor Multa</th>
				<c:forEach items="${listFine}" var="fine">
					<tr>
						<td><c:out value="${fine.id}"></c:out></td>
						<td><c:out value="${fine.date}"></c:out></td>
						<td><c:out value="${fine.description}"></c:out></td>
						<td><c:out value="${fine.conductor.document}"></c:out></td>
						<td><c:out value="${fine.conductor.name}"></c:out></td>
						<td><c:out value="${fine.agent.document}"></c:out></td>
						<td><c:out value="${fine.agent.name}"></c:out></td>
						<td><c:out value="${fine.state}"></c:out></td>
						<td><c:out value="${fine.value}"></c:out></td>
					</tr>
				</c:forEach>
		</table>
		<a href="controlFine.jsp">Volver</a>
	</body>
</html>