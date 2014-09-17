<%@page import="datos.Obra_BD"%>
<%@page import="datos.Socio_BD"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Obra"%>
<%@ page import="entidades.TipoObra"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Socio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp" />

<%
	String busqueda = request.getParameter("busqueda");
	busqueda = busqueda == null ? "" : busqueda;
	final int usuario = 1;
%>

<br>
<a href="Home.jsp" class="btn btn-primary" style="float: left;">Obras</a>
<a href="Listado_Prestamos.jsp" class="btn btn-primary" style="float: left; margin-left: 10px;">Prestamos</a>
<br>
<center>
	<h3>Listado de Socios</h3>
</center>	
<form method="get" class="form-inline" style="padding: 30px 0 30px 20px; border-left: 5px solid #5bc0de">
	<div class="form-group">
		<label>Legajo:  </label>
		<input autofocus class="form-control" type="text" name="busqueda" value="<%=busqueda%>">
	</div>
	<div class="form-group">
		<button type="submit" class="btn btn-default">Buscar</button>
		<a href="?" class="btn btn-default">Limpiar</a>
	</div>
</form>

<table class="table table-striped">
	<tr>
		<th>Legajo</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>E-mail</th>
		<th>Direccion</th>
		<th>Telefono</th>
	</tr>
	<%
		List<Socio> socios = Socio_BD.buscarSocios(request.getParameter("busqueda"));
		for (Socio s : socios) {
	%>
	<tr>
		<td><a href="Socio.jsp?id=<%=s.getIdSocio()%>"><%= s.getLegajo() %></a></td>
		<td><%=s.getNombre()%></td>
		<td><%=s.getApellido()%></td>
		<td><%=s.getEmail()%></td>
		<td><%=s.getDireccion()%>
		<td><%=s.getTelefono()%></td>
	</tr>	
	<%
		}
	%>
</table>

<jsp:include page="Footer.jsp" />