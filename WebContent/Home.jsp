<%@page import="entidades.TipoObra"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Obra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="datos.Obra_BD"%>
<jsp:include page="Header.jsp" />

<%
 String busqueda = request.getParameter("busqueda");
 busqueda = busqueda == null ? "" : busqueda;
%>

<center>
	<h3>Listado de Obras de la Biblioteca</h3>
</center>

<a href="Alta_Obra.jsp" class="btn btn-primary" style="float: right">Agregar
	Obra</a>

<form method="get" class="form-inline"
	style="padding: 30px 0 30px 20px; border-left: 5px solid #5bc0de">
	<div class="form-group">
		<label>Buscar: </label> <input autofocus class="form-control"
			type="text" name="busqueda"
			value="<%= busqueda %>">
	</div>
	<div class="form-group">
		<label> tipo: </label> <select class="form-control" name="tipo">
			<%
				String tipo = request.getParameter("tipo");
				int tipoint = tipo == null ? 1 : Integer.valueOf(tipo);
				
				for (int n = 1; n < 6; n++) {
					if (n == tipoint) {
					%>
						<option selected value="<%= n %>"><%= TipoObra.opciones.get(n) %></option>
						<%
					} else {
						 %>
						<option value="<%= n %>"><%= TipoObra.opciones.get(n) %></option>
					<%
					}
				}
			%>
		</select>
	</div>
	<div class="form-group">
		<button type="submit" class="btn btn-default">Buscar</button>
		<a href="?" class="btn btn-default">Reset</a>
	</div>
</form>

<table border="0" class="table table-striped">
	<tr>
		<th>Imagen</th>
		<th>Título</th>
		<th>Autor</th>
		<th>Tipo de Obra</th>
	</tr>
	<%
		List<Obra> obras = new Obra_BD().buscarObras(request
				.getParameter("busqueda"),
				tipoint);
		for (Obra obra : obras) {
	%>
	<tr>
		<td><a href="Detalle_Obra.jsp?id=<%= obra.getIdObra() %>"><img width="100" src="<%=obra.getImagen()%>" /></a></td>
		<td><%=obra.getTitulo()%></td>
		<td><%=obra.getAutor()%></td>
		<td><%=obra.getTitulo()%></td>
	</tr>
	<%
		}
	%>
</table>

<jsp:include page="Footer.jsp" />