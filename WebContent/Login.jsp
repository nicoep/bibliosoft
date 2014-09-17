<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliosoft Login</title>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="jquery-1.11.1.min.js"></script>
<script src="bootstrap.js"></script>
</head>
<body>
	<center style="margin-top: 100px">
		<div style="width: 280px; padding: 10px;">
			<center>
				<h3>Inicio de Sesión</h3>
			</center>

			<form action="login" method="post" class="form-horizontal">

				<input name="origin" type="hidden"
					value="<%=request.getRequestURL().toString()
					+ "?"
					+ (request.getQueryString() != null ? request
							.getQueryString() : "")%>" />

				<div class="form-group">
					<div class=" col-xs-12">
						<input type="text" name="usuario" placeholder="Usuario"
							class="form-control col-xs-6" />
					</div>
				</div>

				<div class="form-group">
					<div class=" col-xs-12">
						<input type="text" name="clave" placeholder="Contraseña"
							class="form-control" />
					</div>
				</div>

				<div class="form-group" style="text-align: right">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a href="Alta_Usuario.jsp" class="btn btn-link">Crear Usuario</a>
				</div>

			</form>

		</div>
	</center>
	<center style="margin-top: 20px">
		<footer> <b>&copy; Copyright 2014 UTN - FRRo. All rights
			reserved.</b></footer>
	</center>
</body>
</html>