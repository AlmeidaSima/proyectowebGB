|<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
</script>

<title>Cambiar Datos</title>

<h1 align="center">Nuevo autor</h1>
</head>
<div class="container">
<body>
	<%
	String url = "http://localhost:8080/proyectowebGB/";
	%>

	<h3>Nuevo autor</h3>

	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type="hidden" name="op" value="insertar"> <label
		
			for="nombre">Nombre del autor</label> <input type="text"
			class="form-control" name="nombre" id="nombre" value=""
			placeholder="Ingresa el nombre del autor"> <span
			class="input-group-addon"><span
			class="glyphicon 
glyphicon-asterisk"></span></span>


		<div class="form-group">
			<label for="contacto">Nacionalidad del autor:</label>
			<div class="input-group">
				<input type="text" class="form-control" id="contacto" value=""
					name="nacionalidad" placeholder="Ingresa la nacionalidad del autor">
				<span class="input-group-addon"><span
					class="glyphicon 
glyphicon-asterisk"></span></span>
			</div>
		</div>

		<input type="submit" class="btn btn-info" value="Guardar"
			name="Guardar"> <a class="btn btn-danger"
			href="<%=url%>AutoresController?op=listar">Cancelar</a>
	</form>
</body>
</div>
</html>
