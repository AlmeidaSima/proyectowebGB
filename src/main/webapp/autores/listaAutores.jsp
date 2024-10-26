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
    String url = "http://localhost:8080/proyectowebGB/";
    %>
	<h1>Lista de Elementos</h1>
	<a type="button" href="<%=url%>AutoresController?op=nuevo"> Nuevo autor</a>
	
	<table id="tablalista" border="1">
		<thead>
			<tr>
				<th>Cod Autor</th>
				<th>Nombre</th>
				<th>Nacionalidad</th>
				<th>Operaciones</th>
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
				<td>
			<a href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">Modificar</a> 
			
			<a href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar </a>
			</td>
				
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