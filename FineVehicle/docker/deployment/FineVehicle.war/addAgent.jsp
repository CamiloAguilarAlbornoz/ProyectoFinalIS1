<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar Agente</title>
	</head>
	<body>
		<h1>Ingrese los datos pertinentes del agente</h1>
		<form action="AddAgenteServlet" method="post">
			<table border="1">
				<tr>
					<th colspan="2">Datos del agente</th>
				</tr>
				<tr>
					<td>Ingrese la cedula del agente</td>
					<td>
						<input placeholder="Cedula" name="document" type="number" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese el nombre del agente</td>
					<td>
						<input placeholder="Nombre" name="name" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese el apellido del agente</td>
					<td>
						<input placeholder="Apellido" name="lastName" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese la direccion del agente</td>
					<td>
						<input placeholder="Direccion" name="direction" type="text" required/>
					</td>
				</tr>
				</table>
			<input type="submit" value="Crear"/>
		</form>
		<a href="controlAgent.jsp">Cancelar</a>
	</body>
</html>