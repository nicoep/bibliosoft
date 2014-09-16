<%@page import="datos.Socio_BD"%>
<%@page import="datos.Prestamo_BD"%>
<%@page import="entidades.Prestamo"%>
<%@page import="entidades.Obra"%>
<%@page import="datos.Obra_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />

<%
	Prestamo prestamo = Prestamo_BD.getPrestamo(Integer
			.valueOf(request.getParameter("id")));
%>
<center>
	<h3>Datos del Prestamo</h3>
</center>
<br>
<form action="modifica_obra" method="post" class="form-horizontal">

	<div class="form-group">
		<label class="col-sm-3 control-label">Id del Prestamo:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=prestamo.getIdPrestamo()%></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Id del Socio:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=prestamo.getIdSocio()%></label>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Legajo del Socio:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=Socio_BD.traerLegajo(prestamo.getIdSocio())%></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Id de la Obra:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=prestamo.getIdObra()%></label>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Titulo de la Obra:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=Obra_BD.traerTitulo(prestamo.getIdObra())%></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Fecha de Retiro:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=prestamo.getFechaRetiro() == null ? "" : prestamo.getFechaRetiro()%></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Fecha de Devolucion:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=prestamo.getFechaDevolucion() == null ? "" : prestamo.getFechaDevolucion()%></label>
		</div>
	</div>

	<br>

	<div class="form-group" style="text-align: center">
		<a href="/bibliosoft/Listado_Prestamos.jsp" class="btn btn-danger">Volver</a>
		<% if (prestamo.getFechaRetiro() == null) {
		%>
		<input type="submit" value="Cancelar" name="action" class="btn btn-success">
		<input type="submit" value="Retirar" name="action" class="btn btn-success">
		<% } else if (prestamo.getFechaDevolucion() == null) { %>
		<input type="submit" value="Finalizar" name="action" class="btn btn-success">
		<% } %>
	</div>
</form>
<jsp:include page="Footer.jsp" />