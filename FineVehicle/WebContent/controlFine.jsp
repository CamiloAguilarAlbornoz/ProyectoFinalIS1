<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Controlador de multas</title>
	<link rel="shortcut icon" href="https://www.flaticon.es/svg/static/icons/svg/2333/2333368.svg" type="image/x-svg" />
	<link rel="stylesheet" href="css/controlFine.css" type="text/css" media="all" />
	<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&display=swap" rel="stylesheet" />
</head>

<body>
	<header class="main-header">
		<h1 class="title">Sistema Integrado de Multas e Infracciones</h1>
	</header>
	<section class="main">
		<h1>Control de Multas</h1>
		<form method="get" action="FineServlet">
			<div class="flex-container">
				<div class="container">
					<input class="image-button img-1" value="Crear multa" type="submit" name="Crear Multa" alt="flecha adelante" />
					<div class="inside-text">Crear multa</div>
				</div>
				<div class="container">
					<input class="image-button img-2" value="Listado de multas" type="submit" name="Listado de multas"
						alt="flecha adelante" />
					<div class="inside-text">Listado de multas</div>
				</div>
				<div class="container">
					<input class="image-button img-3" value="Cambiar estado de multa" type="submit" name="Cambiar estado de multa"
						alt="flecha adelante" />
					<div class="inside-text">Cambiar estado de multa</div>
				</div>
				<a href="index.jsp"><button class="button">Volver al inicio</button></a>
		</form>
	</section>
</body>
</html>