<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Probando0 listado</title>
</head>
<body>
    <%
    String url = "http://localhost:8089/proyectoWebGB/";
    %>
	<h1>Lista de Elementos</h1>
	<a type=button href="<%=url%>AutoresController?op=nuevo"> Nuevo Autor</a>
	<table id="tablalista" border="1">
		<thead>
			<tr>
				<th>Codigo Autor</th>
				<th>Nombre</th>
				<th>Nacionalidad</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
			if (listaAutores != null) {
				for (Autor autor : listaAutores) {
			%>
			<tr>
				<td><%=autor.getIdAutor() %></td>
				<td><%=autor.getNombre() %></td>
				<td><%=autor.getNacionalidad() %></td>
			</tr>

			<%
			    }
			}else {
			%>
			
			<tr>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>
			</tr>
			
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>