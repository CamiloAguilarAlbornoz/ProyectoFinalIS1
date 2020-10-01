<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar Conductor</title>
		<link rel="shortcut icon" href="https://www.flaticon.es/svg/static/icons/svg/2333/2333368.svg" type="image/x-svg" />
		<link rel="stylesheet" href="css/addConductor.css" type="text/css" media="all" />
		<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&display=swap" rel="stylesheet">
	</head>
	<body>
		<header class="main-header">
			<h1 class="title">Sistema Integrado de Multas e Infracciones </h1>
		</header>
		<form class="main" action="AddConductorServlet" method="post">
			<h1>Ingrese los datos pertinentes del conductor</h1>
			<div class="container form">
				<h2 class="label">Datos del conductor</h2>
				<label class="label">Cedula: <input type="text" id="Cedula" name="Cedula" /></label>
				<label class="label">Nombres: <input type="text" id="Nombres" name="Nombres" /></label>
				<label class="label">Apellidos: <input type="text" id="Apellidos" name="Apellidos" /></label>
				<label class="label">Direccion: <input type="text" id="Direccion" name="Direccion" /></label>			
				<label class="label">Fecha de Expedicion: <input type="text" id="ExpeditionDate" name="ExpeditionDate" /></label>			
				<label class="label">Fecha de Expiracion: <input type="text" id="ExpirationDate" name="ExpirationDate" /></label>			
			</div>
			<div class="container image">
				<img src="https://www.flaticon.es/svg/static/icons/svg/2898/2898532.svg" alt="licensePlate">
			</div>
			<div class="container form">
				<h2 class="label">Datos del Vehiculo</h2>
				<label class="label">Placas: <input type="text" id="plate" name="plate" /></label>			
				<label class="label">Marca: <input type="text" id="model" name="model" /></label>			
				<label class="label">Año: <input type="text" id="year" name="year" /></label>			
				<div class="main buttons">
					<input class="button" type="submit" value="Crear"/>
					<a href="controlConductor.jsp"><button class="button">Cancelar</button></a>
				</div>	
			</div>
			<div class="container image">
				<img src="https://www.flaticon.es/svg/static/icons/svg/2882/2882002.svg" alt="licensePlate">
			</div>
		</form>
		<a href="controlConductor.jsp">Cancelar</a>
	</body>
</html>