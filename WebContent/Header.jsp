<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliosoft</title>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="jquery-1.11.1.min.js"></script>
<script src="bootstrap.js"></script>
</head>
<body class="container">
	<div class="container">
		<h1 style="float:left">Biblioteca UTN FRRo</h1>
		<div style="float:right; margin-top: 20px">
			<div class="dropdown" style="display: inline-block">
				<a data-toggle="dropdown" class="btn btn-primary">Login</a>
				<ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dLabel">
					<div style="width: 280px; padding: 10px;">
						<center>
							<h3>Inicio de Sesión</h3>
						</center>
						<form action="login" method="post" class="form-horizontal">
							<div class="form-group">
								<div class=" col-xs-12">
									<input type="text" name="usuario" placeholder="Usuario"
										class="form-control col-xs-6" />
								</div>
							</div>
							<div class="form-group">
								<div class=" col-xs-12">
									<input type="text" name="contraseña" placeholder="Contraseña"
										class="form-control" />
								</div>
							</div>
							<div class="form-group" style="text-align: right">
								<button type="button" class="btn btn-primary">Aceptar</button>
								<a href="RegistrarUsuario.jsp" class="btn btn-link">Crear
									Usuario</a>
							</div>
						</form>
					</div>
				</ul>
			</div>
			<button type="button" class="btn btn-danger">Salir</button>
		</div>
	</div>
	<div class="container">