<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar Conductor</title>
	</head>
	<body>
		<h1>Ingrese los datos pertinentes del conductor</h1>
		<form action="AddConductorServlet" method="post">
			<table border="1">
				<tr>
					<th colspan="2">Datos del conductor</th>
				</tr>
				<tr>
					<td>Ingrese la cedula del conductor</td>
					<td>
						<input placeholder="Cedula" name="document" type="number" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese el nombre del conductor</td>
					<td>
						<input placeholder="Nombre" name="name" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese el apellido del conductor</td>
					<td>
						<input placeholder="Apellido" name="lastName" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese la direccion del conductor</td>
					<td>
						<input placeholder="Direccion" name="direction" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese la fecha de expedicion de la licensia</td>
					<td>
						<input placeholder="yyyy/MM/dd" name="dateExpedition" type="date" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese la fecha de expiraccion de la licensia</td>
					<td>
						<input placeholder="yyyy/MM/dd" name="dateExpiration" type="date" required/>
					</td>
				</tr>
				<tr>
					<th colspan="2">Datos del vehiculo</th>
				</tr>
				<tr>
					<td>Ingrese las placas del vehiculo</td>
					<td>
						<input placeholder="Placas" name="licensePlate" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese la marca del vehiculo</td>
					<td>
						<input placeholder="Marca" name="trademark" type="text" required/>
					</td>
				</tr>
				<tr>
					<td>Ingrese el año del vehiculo</td>
					<td>
						<input placeholder="Año" name="year" type="number" required/>
					</td>
				</tr>
			</table>
			<input type="submit" value="Crear"/>
		</form>
		<a href="controlConductor.jsp">Cancelar</a>
	</body>
</html>