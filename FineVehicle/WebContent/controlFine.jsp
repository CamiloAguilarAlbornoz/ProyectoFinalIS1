<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Controlador de multas</title>
	</head>
	<body>
		<h1>Control de Multas</h1>
		<form method="get" action="FineServlet">
			<input type="submit" value="Crear multa" name="control"/>
			<input type="submit" value="Listado de multas" name="control"/>
			<input type="submit" value="Cambiar estado de multa" name="control"/>
		</form>
		<a href="index.jsp">Volver</a>
	</body>
</html>