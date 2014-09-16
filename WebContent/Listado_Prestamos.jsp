<%@page import="java.util.List"%>
<%@page import="datos.Prestamo_BD"%>
<%@page import="entidades.Prestamo"%>
<%@page import="entidades.TipoObra"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Obra"%>
<%@page import="entidades.Prestamo"%>
<%@ page import="datos.Obra_BD"%>
<%@ page import="datos.Socio_BD"%>
<%@ page import="datos.Prestamo_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp" />

<%
	String busqueda = request.getParameter("busqueda");
	busqueda = busqueda == null ? "" : busqueda;
	final int usuario = 2;
%>

<br>
<a href="Listado_Socios.jsp" class="btn btn-primary" style="float: right">Socios</a>
<a href="Home.jsp" class="btn btn-primary" style="float: right">Obras</a>
<br>
<center>
	<h3>Listado de Prestamos</h3>
</center>	
<form method="get" class="form-inline" style="padding: 30px 0 30px 20px; border-left: 5px solid #5bc0de">
	<div class="form-group">
		<label> Estado: </label> <select class="form-control" name="tipo">
			<%
				String tipo = request.getParameter("tipo");
				int tipoint = tipo == null ? 1 : Integer.valueOf(tipo);

				for (int n = 1; n < 6; n++) {
					if (n == tipoint) {
			%>
			<option selected value="<%=n%>"><%=TipoObra.opciones.get(n)%></option>
			<%
				} else {
			%>
			<option value="<%=n%>"><%=TipoObra.opciones.get(n)%></option>
			<%
				}
				}
			%>
		</select>
	</div>
	<div class="form-group">
		<button type="submit" class="btn btn-default">Buscar</button>
		<a href="?" class="btn btn-default">Limpiar</a>
	</div>
</form>

<table class="table table-striped">
	<tr>
		<th>idPrestamo</th>
		<th>Legajo Socio</th>
		<th>Titulo</th>
		<th>Fecha de Retiro</th>
		<th>Fecha de Devolucion</th>
	</tr>
	<%
		List<Prestamo> prestamos = Prestamo_BD.buscarPrestamos();
		for (Prestamo p : prestamos) {
			String legajo = Socio_BD.traerLegajo(p.getIdSocio());
			String titulo = Obra_BD.traerTitulo(p.getIdObra());
	%>
	<tr>
		<td><a href="Prestamo.jsp?id=<%=p.getIdPrestamo()%>"><%= p.getIdPrestamo() %></a></td>
		<td><%= legajo %></td>
		<td><%= titulo %></td>
		<td><%= p.getFechaRetiro() == null ? "" : p.getFechaRetiro() %>
		<td><%= p.getFechaDevolucion() == null ? "" : p.getFechaDevolucion() %></td>
	</tr>
	<%
		}
	%>
</table>

<jsp:include page="Footer.jsp" />