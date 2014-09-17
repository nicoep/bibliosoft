<%@page import="entidades.Socio"%>
<%@page import="datos.Socio_BD"%>
<%@page import="datos.Prestamo_BD"%>
<%@page import="entidades.Prestamo"%>
<%@page import="entidades.Obra"%>
<%@page import="datos.Obra_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />

<%
	Socio s = Socio_BD.getSocio(Integer.valueOf(request.getParameter("id")));
%>
<center>
	<h3>Datos del Socio</h3>
</center>
<br>
<form action="modifica_socio" method="post" class="form-horizontal">

	<div class="form-group">
		<label class="col-sm-3 control-label">Id del Socio:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getIdSocio()%>" name="idSocio" style="text-align: left; font-weight: bold;" readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Nombre:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getNombre()%>" name="nombre" style="text-align: left; font-weight: bold;">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Apellido:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getApellido()%>" name="apellido" style="text-align: left; font-weight: bold;">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">D.N.I.:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getDni()%>" name="dni" style="text-align: left; font-weight: bold;">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Direccion:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getDireccion()%>" name="direccion" style="text-align: left; font-weight: bold;">
			
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Email</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getEmail()%>" name="email" style="text-align: left; font-weight: bold;">
			
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Legajo:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getLegajo()%>" name="legajo" style="text-align: left; font-weight: bold;">
		</div>
	</div>
	
		<div class="form-group">
		<label class="col-sm-3 control-label">Telefono:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=s.getLegajo()%>" name="telefono" style="text-align: left; font-weight: bold;">
		</div>
	</div>

	<br>

	<div class="form-group" style="text-align: center">
		<a href="/bibliosoft/Listado_Socios.jsp" class="btn btn-danger">Volver</a>
		<input type="submit" value="Guardar" name="action" class="btn btn-success">
	</div>
</form>
<jsp:include page="Footer.jsp" />