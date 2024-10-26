<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
   String url = "http://localhost:8089/proyectoWebGB/";
   %>
   <h3>Nuevo Autor</h3>
   <form role="form" action="<%=url%>AutoresController" method="POST">
   <input type="hidden" name="op" value="insertar">
   Nombre del Autor <input type="text" name="nombreAutor" id="nombreAutor" ><br>
   Nacionalidad <input type="text" name="nacionalidadAutor" id="nacionalidadAutor"><br>
   <input type="submit" value="guardar" name="Guardar">
   <a href="<%=url%>AutoresController?op=listar">Volver</a>
   </form>
</body>
</html>