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
				<div class="grid-container">
					<article class="container">
						<input class="image-button" type="image" value="Crear conductor" name="control"
						src="https://www.flaticon.es/svg/static/icons/svg/3556/3556656.svg" alt="Submit" />
						<div class="inside-text">Crear Conductor</div> 
						<!-- -<input class="inside-text" placeholder="Text" value="Crear conductor" name="control" type="submit"/>-->
					</article>
					<article class="container">
					<input class="image-button" type="image" value="Listado de conductores" name="control" src="https://www.flaticon.es/svg/static/icons/svg/3500/3500043.svg"
								alt="señales invertidas" />
							<div class="inside-text">Listado de Conductores</div>
					</article>
					<article class="container">
						<input class="image-button" type="image" value="Eliminar conductor" name="control" src="https://www.flaticon.es/svg/static/icons/svg/879/879386.svg" alt="señal de stop" />
							<div class="inside-text">Eliminar conductor</div>
					</article>
					<article class="container">
						<input class="image-button" type="image" value="Modificar conductor" name="control" src="https://www.flaticon.es/svg/static/icons/svg/835/835958.svg" alt="transeuntes" />
							<div class="inside-text">Modificar conductor</div>					
					</article>
				</div>
			</form>
			<a href="index.jsp"><button class="button">Volver al inicio</button></a>
		</section>
	</body>
</html>