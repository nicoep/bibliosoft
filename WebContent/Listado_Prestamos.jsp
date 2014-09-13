<%@page import="entidades.TipoObra"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Obra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="datos.Obra_BD"%>
<%@ page import="datos.Socio_BD"%>

<jsp:include page="Header.jsp" />

<%
	String busqueda = request.getParameter("busqueda");
	busqueda = busqueda == null ? "" : busqueda;
	final int usuario = 2;
%>

<center>
	<h3>Listado de Prestamos</h3>
</center>
<br>
<a href="Alta_Obra.jsp" class="btn btn-primary" style="float: right">Agregar Obra</a>
<a href="Listado_Socios.jsp" class="btn btn-primary" style="float: right">Listado de Socios</a>
<a href="Listado_Prestamos.jsp" class="btn btn-primary" style="float: right">Listado de Prestamos</a>
<br>	
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
		<th>idSocio</th>
		<th>idObra</th>
		<th>Fecha de Retiro</th>
		<th>Fecha de Devolucion</th>
	</tr>
	<%
		List<Obra> obras = new Obra_BD().buscarObras(request.getParameter("busqueda"), tipoint);
		for (Obra obra : obras) {
	%>
	<tr>
		<td><a href="Modificar_Obra.jsp?id=<%=obra.getIdObra()%>"><img width="100" src="<%=obra.getImagen()%>" /></a></td>
		<td><%=obra.getTitulo()%></td>
		<td><%=obra.getAutor()%></td>
		<td><%=obra.getTitulo()%></td>
	</tr>
	<%
		}
	%>
</table>

<jsp:include page="Footer.jsp" />