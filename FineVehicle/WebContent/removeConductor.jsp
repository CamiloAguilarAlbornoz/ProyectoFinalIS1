<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eliminar conductor</title>
	</head>
	<body>
		<h1>Ingrese los datos solicitados</h1>
		<form method="post" action="RemoveConductorServlet">
			<label for="remove">Ingrese el documento del conductor a eliminar:</label>
			<input id="remove" placeholder="Documento" type="number" name="documento" required/>
			<input type="submit" value="Eliminar"/>
		</form>
		<a href="controlConductor.jsp">Cancelar</a>
	</body>
</html>