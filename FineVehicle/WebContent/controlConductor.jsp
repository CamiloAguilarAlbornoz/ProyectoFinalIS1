<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Controlador de conductores</title>
	</head>
	<body>
		<h1>Control de Conductores</h1>
		<form method="get" action="ConductorServlet">
			<input type="submit" value="Crear conductor" name="control"/>
			<input type="submit" value="Listado de conductores" name="control"/>
			<input type="submit" value="Eliminar conductor" name="control"/>
			<input type="submit" value="Modificar conductor" name="control"/>
		</form>
		<a href="index.jsp">Volver</a>
	</body>
</html>