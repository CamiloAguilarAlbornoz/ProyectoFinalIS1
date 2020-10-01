<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	
	<head>
		<meta charset="UTF-8" />
		<title>Gestion de Conductores</title>
		<link rel="shortcut icon" href="https://www.flaticon.es/svg/static/icons/svg/2333/2333368.svg" type="image/x-svg" />
		<link rel="stylesheet" href="css/controlConductor.css" type="text/css" media="all" />
		<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&display=swap" rel="stylesheet" />
	</head>
	
	<body>
		<header class="main-header">
			<h1 class="title">Sistema Integrado de Multas e Infracciones</h1>
		</header>
	
		<section class="main">
			<h1>Control de Conductores</h1>
			<form id="myform" method="get" action="ConductorServlet">
				<div class="flex-container">
					<div class="container">
						<input class="image-button img-1" value="" type="submit" name="CrearConductor" alt="flecha adelante"/>
						<div class="inside-text">Crear conductor</div>
					</div>
					<div class="container">
						<input class="image-button img-2" value="" type="submit" name="ListadoConductores" alt="flecha adelante"/>
						<div class="inside-text">Listado de Conductores</div>
					</div>
					<div class="container">
						<input class="image-button img-3" value="" type="submit" name="Eliminar conductor" alt="flecha adelante"/>
						<div class="inside-text">Eliminar conductor</div>
					</div>
					<div class="container">
						<input class="image-button img-4" value="" type="submit" name="Modificar conductor" alt="flecha adelante"/>
						<div class="inside-text">Modificar conductor</div>
					</div>
				</div>
			</form>
			<a href="index.html"><button class="button">Volver al inicio</button></a>
		</section>
	</body>
	
	</html>