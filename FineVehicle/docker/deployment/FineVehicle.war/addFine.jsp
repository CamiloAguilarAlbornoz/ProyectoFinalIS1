<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar Multa</title>
	</head>
	<body>
		<h1>Ingrese los datos pertinentes a la multa</h1>
		<form action="AddFineServlet" method="post">
			<table border="1">
				<tr>
					<th colspan="2">Datos de la multa</th>
				</tr>
				<tr>
					<td>Ingrese el id de la multa</td>
					<td>
						<input placeholder="id" name="id" type="number" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese la descripcion de la multa</td>
					<td>
						<input placeholder="Descripcin" name="descripcion" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Seleccione el conductor al cual asignar la multa</td>
					<td>
						<select name="conductorsList" required>
							<c:forEach items="${listConductors}" var="conductor">
								<option><c:out value="${conductor.document}"></c:out></option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Seleccione el agente responsable de la multa</td>
					<td>
						<select name="agentsList" required>
							<c:forEach items="${listAgents}" var="agent">
								<option><c:out value="${agent.document}"></c:out></option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Ingrese el valor de la multa mayor o igual a 10000</td>
					<td>
						<input placeholder="Valor" name="value" type="number" required/>
					</td>
				</tr>
			</table>
			<input type="submit" value="Crear"/>
		</form>
		<a href="controlFine.jsp">Cancelar</a>
	</body>
</html>