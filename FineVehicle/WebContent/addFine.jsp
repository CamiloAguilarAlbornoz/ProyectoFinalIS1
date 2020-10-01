<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Agregar Multa</title>
	<link rel="shortcut icon" href="https://www.flaticon.es/svg/static/icons/svg/2333/2333368.svg" type="image/x-svg" />
	<link rel="stylesheet" href="css/addFine.css" type="text/css" media="all" />
	<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&display=swap" rel="stylesheet">
</head>

<body>
	<header class="main-header">
		<h1 class="title">Sistema Integrado de Multas e Infracciones </h1>
	</header>
	<form class="main" action="AddFineServlet" method="post">
		<h1 class="title">Ingrese los datos pertinentes a la multa</h1>
		<div class="container form">
			<h2 class="title">Datos de la multa</h2>
			<label class="label">Identificador: <input type="number" id="id" name="id" required /></label>
			<label class="label">descripcion: <input type="text" id="descripcion" name="descripcion" required /></label>
			<label class="label">Seleccione el conductor al cual asignar la multa:
				<select name="conductorsList" required>
					<c:forEach items="${listConductors}" var="conductor">
						<option>
							<c:out value="${conductor.document}"></c:out>
						</option>
					</c:forEach>
				</select>
			</label>
			<label class="label">Seleccione el agente responsable de la multa:
				<select name="agentsList" required>
					<c:forEach items="${listAgents}" var="agent">
						<option>
							<c:out value="${agent.document}"></c:out>
						</option>
					</c:forEach>
				</select>
			</label>
			<label class="label">Ingrese el valor de la multa mayor o igual a 10000
				<input type="number" placeholder="Valor" id="value" name="value" required />
			</label>
			<div class="main buttons">
				<input class="button" type="submit" value="Crear" />
				<a href="controlFine.jsp"><button class="button">Cancelar</button></a>
			</div>
		</div>
		<div class="container image">
			<img src="https://www.flaticon.es/svg/static/icons/svg/1655/1655267.svg" alt="licensePlate">
		</div>
	</form>
</body>

</html>