<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar Agente</title>
		<link rel="shortcut icon" href="https://www.flaticon.es/svg/static/icons/svg/2333/2333368.svg" type="image/x-svg" />
		<link rel="stylesheet" href="css/addAgent.css" type="text/css" media="all" />
		<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&display=swap" rel="stylesheet">
	</head>
	<body>
		<header class="main-header">
			<h1 class="title">Sistema Integrado de Multas e Infracciones </h1>
		</header>
		<form class="main" action="AddAgenteServlet" method="post">
			<h1 class="title">Ingrese los datos pertinentes del agente</h1>
			<div class="container">
				<label class="label">Cedula: <input type="text" id="Cedula" name="Cedula" /></label>
				<label class="label">Nombres: <input type="text" id="Nombres" name="Nombres" /></label>
				<label class="label">Apellidos: <input type="text" id="Apellidos" name="Apellidos" /></label>
				<label class="label">Direccion: <input type="text" id="Direccion" name="Direccion" /></label>			
				<div class="main buttons">
					<input class="button" type="submit" value="Crear"/>
					<a href="controlAgent.jsp"><button class="button">Cancelar</button></a>
				</div>
			</div>
			<div class="container">
				<img src="https://www.flaticon.es/svg/static/icons/svg/2991/2991206.svg" alt="Police">
			</div>
		</form>
		</section>
	</body>
</html>