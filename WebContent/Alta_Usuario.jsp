<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<center>
	<h3>Registro de Socio</h3>
</center>
<form action="registrar_usuario" method="post" class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-3 control-label">Nombre:</label>
		<div class="col-sm-6">
			<input class="form-control" name="nombre">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Apellido:</label>
		<div class="col-sm-6">
			<input class="form-control" name="apellido">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">D.N.I.:</label>
		<div class="col-sm-6">
			<input class="form-control" name="dni">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Dirección:</label>
		<div class="col-sm-6">
			<input class="form-control" name="direccion">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Teléfono:</label>
		<div class="col-sm-6">
			<input class="form-control" name="telefono">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">E-mail:</label>
		<div class="col-sm-6">
			<input class="form-control" name="email">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Legajo:</label>
		<div class="col-sm-6">
			<input class="form-control" name="legajo">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Usuario:</label>
		<div class="col-sm-6">
			<input class="form-control" name="usuario">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Clave:</label>
		<div class="col-sm-6">
			<input class="form-control" name="clave">
		</div>
	</div>
	<div class="form-group" style="text-align: center">
		<a href="/bibliosoft/" class="btn btn-danger">Volver</a>
		<button type="submit" class="btn btn-success">Registrarse</button>
	</div>
</form>
<jsp:include page="Footer.jsp" />