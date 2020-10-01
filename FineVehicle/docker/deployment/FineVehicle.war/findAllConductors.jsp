<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de conductores</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th colspan="10">Lista de conductores</th>
			</tr>
			<tr>
				<th>Documento</th>
				<th>Nombres</th>
				<th>Apellidos</th>
				<th>Direccion</th>
				<th>Fecha expedicion Licencia</th>
				<th>Fecha expiracion Licencia</th>
				<th>Estado</th>
				<th>Placa de su vehiculo</th>
				<th>Año del vehiculo</th>
				<th>Marca del vehiculo</th>
				<c:forEach items="${listConductor}" var="conductor">
					<tr>
						<td><c:out value="${conductor.document}"></c:out></td>
						<td><c:out value="${conductor.name}"></c:out></td>
						<td><c:out value="${conductor.lastName}"></c:out></td>
						<td><c:out value="${conductor.direction}"></c:out></td>
						<td><c:out value="${conductor.dateExpedition}"></c:out></td>
						<td><c:out value="${conductor.dateExpiration}"></c:out></td>
						<td><c:out value="${conductor.state}"></c:out></td>
						<td><c:out value="${conductor.vehicle.licensePlate}"></c:out></td>
						<td><c:out value="${conductor.vehicle.year}"></c:out></td>
						<td><c:out value="${conductor.vehicle.trademark}"></c:out></td>
					</tr>
				</c:forEach>
		</table>
		<a href="controlConductor.jsp">Volver</a>
	</body>
</html>