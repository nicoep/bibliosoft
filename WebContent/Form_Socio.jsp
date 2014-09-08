<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario de Contacto</title>
</head>
<body>
	<div>
		<h1>Sistema de Gestión de Biblioteca UTN FRRo</h1>
	</div>
	<div>
		<h3>Registro de Socio</h3>
		<form action="registrar_usuario" method="post">
			<p><label>Nombre:</label><input name="nombre"></p>
			<p><label>Apellido:</label><input name="apellido"></p>
			<p><label>D.N.I.:</label><input name="dni"></p>
			<p><label>Dirección:</label><input name="direccion"></p>
			<p><label>Teléfono:</label><input name="telefono"></p>
			<p><label>E-mail:</label><input name="email"></p>
			<p><label>Legajo:</label><input name="legajo"></p>
			<p><input type="submit" value="Registrarse"></p>
		</form>
	</div>

</body>
</html>