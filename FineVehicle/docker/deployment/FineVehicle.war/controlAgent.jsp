<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Controlador de agentes</title>
	</head>
	<body>
		<h1>Control de Agentes</h1>
		<form method="get" action="AgentServlet">
			<input type="submit" value="Crear agente" name="control"/>
			<input type="submit" value="Listado de agentes" name="control"/>
			<input type="submit" value="Eliminar agente" name="control"/>
			<input type="submit" value="Modificar agente" name="control"/>
		</form>
		<a href="index.jsp">Volver</a>
	</body>
</html>