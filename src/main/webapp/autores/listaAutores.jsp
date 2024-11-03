<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
</script>
<script>
	function eliminar(id){
		if(confirm("desea eliminar el registro")==true){
			location.href = "AutoresController?op=eliminar&id="+ id;
		}else{			
		}
	}
</script>

<title>Probando0 listado</title>
</head>
<body>
    <%
    String url = "http://localhost:8080/proyectowebGB/";
    %>
	<h1>Lista de Elementos</h1>
	<div class="container mt-6">
    <a class="btn btn-primary mb-3" href="<%=url%>AutoresController?op=nuevo">Nuevo autor</a>  
    <table id="tablalista" class="table table-hover table-bordered">
        <thead>
            <tr class="table-primary text-center ">
                <th>Cod Autor</th>
                <th>Nombre</th>
                <th>Nacionalidad</th>
                <th>Operaciones</th>
            </tr>
        </thead>
        <tbody>
            <% List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
            if (listaAutores != null && !listaAutores.isEmpty()) {
                for (Autor autor : listaAutores) { %>
                <tr>
                    <td class="text-center"><%= autor.getIdAutor() %></td>
                    <td><%= autor.getNombre() %></td>
                    <td><%= autor.getNacionalidad() %></td>
                    <td class="text-center">
                        <!-- Botones de operación -->
                        <a class="btn btn-sm btn-warning" href="<%=url%>AutoresController?op=obtener&id=
                        <%=autor.getIdAutor()%>">
                            Modificar
                        </a>
                        
                    <!--    <a class="btn btn-sm btn-danger" href="<%=url%>AutoresController?op=eliminar&id=
                        <%=autor.getIdAutor()%>">
                            Eliminar
                        </a>-->
                        
                        <a href="javascript:eliminar('<%=autor.getIdAutor() %>')"
                        class="btn btn-danger">eliminar</a>
                    </td>
                </tr>
            <% } } else { %>
                <tr>
                    <td colspan="4" class="text-center">No hay datos disponibles</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>