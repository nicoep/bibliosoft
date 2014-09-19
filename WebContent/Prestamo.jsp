<%@page import="datos.Socio_BD"%>
<%@page import="datos.Prestamo_BD"%>
<%@page import="entidades.Prestamo"%>
<%@page import="entidades.Obra"%>
<%@page import="datos.Obra_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />

<%
	Prestamo prestamo = Prestamo_BD.getPrestamo(Integer.valueOf(request.getParameter("id")));
%>
<center>
	<h3>Datos del Prestamo</h3>
</center>
<br>

<form action="modifica_prestamo" method="post" class="form-horizontal">

	<div class="form-group">
		<label class="col-sm-3 control-label">Id del Prestamo:</label>
		<div class="col-sm-6">
			<input class="form-control" name="idPrestamo" value="<%=prestamo.getIdPrestamo()%>" readonly="readonly" style="text-align:left"> 
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Id del Socio:</label>
		<div class="col-sm-6">
			<input class="form-control" name="idSocio" value="<%= prestamo.getIdSocio() %>" readonly="readonly" style="text-align:left">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Legajo del Socio:</label>
		<div class="col-sm-6">
			<input class="form-control" name="legajo" value="<%= Socio_BD.traerLegajo(prestamo.getIdSocio()) %>" readonly="readonly" style="text-align:left">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Id de la Obra:</label>
		<div class="col-sm-6">
			<input class="form-control" name="idObra" value="<%= prestamo.getIdObra() %>" readonly="readonly" style="text-align:left">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Titulo de la Obra:</label>
		<div class="col-sm-6">
			<input class="form-control" name="titulo" value="<%= Obra_BD.traerTitulo(prestamo.getIdObra()) %>" readonly="readonly" style="text-align:left">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Fecha de Retiro:</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="fechaRetiro" value="<%= prestamo.getFechaRetiro() == null ? "" : prestamo.getFechaRetiro() %>" style="text-align:left" readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Fecha de Devolucion:</label>
		<div class="col-sm-6">
			<input class="form-control" name="fechaDevolucion" value="<%= prestamo.getFechaDevolucion() == null ? "" : prestamo.getFechaDevolucion() %>" style="text-align:left" readonly="readonly">
		</div>
	</div>

	<br>

	<div class="form-group" style="text-align: center">
	
		<a href="Listado_Prestamos.jsp" class="btn btn-danger">Volver</a>
		
		<% if (prestamo.getFechaRetiro() == null) { %>
			<input type="submit" value="Cancelar" name="action" class="btn btn-warning">
			<input type="submit" value="Retirar" name="action" class="btn btn-success">
		<% } else if (prestamo.getFechaDevolucion() == null) { %>
			<input type="submit" value="Finalizar" name="action" class="btn btn-success">
		<% } %>
		
	</div>
	
</form>
<jsp:include page="Footer.jsp" />