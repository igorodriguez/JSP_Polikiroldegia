<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.bean.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%
    Usuario usuario = (Usuario)request.getAttribute("actividad");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Usuario</title>
</head>
<body>
<div class="container mt-5 rounded border border-dark">
		<div class="row">
			<div class="col">
				<h1 class="text-center"></h1>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">Apellido</div>
			<div class="col text-center font-weight-bold"> %></div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">DNI</div>
			<div class="col text-center font-weight-bold"><%=usuario.getDni() %></div>
		</div>
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">
				<a class="btn btn-primary" href="EditarUsuario?id=<%= usuario.getId() %>">Editar</a>
			</div>
			<div class="col text-center font-weight-bold">
				<a class="btn btn-danger" href="EliminarUsuario?id=<%= usuario.getId() %>">Eliminar</a>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col">
				<a href="VerUsuarios">Ver usuarios</a>
			</div>
			
		</div>
		<br>
	</div>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>