<%@page import="entidades.TipoObra"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Obra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="datos.Obra_BD"%>

<jsp:include page="Header.jsp" />

<%
	String busqueda = request.getParameter("busqueda");
	busqueda = busqueda == null ? "" : busqueda;
	String usuario = request.getSession().getAttribute("user") == null ? "socio" : request.getSession().getAttribute("user").toString();
%>

<%if (usuario.contains("1")) { %>
<br>
<a href="Listado_Socios.jsp" class="btn btn-info" style="float: left">Socios</a>
<a href="Listado_Prestamos.jsp" class="btn btn-info" style="float: left; margin-left: 10px;">Prestamos</a>
<br>
<% } %>


<center>
	<h3>Listado de Obras</h3>
</center>
	
<form method="get" class="form-inline" style="padding: 30px 0 30px 20px; border-left: 5px solid #5bc0de">
	<div class="form-group">
		<label>Buscar: </label>
		<input autofocus class="form-control" type="text" name="busqueda" value="<%=busqueda%>">
	</div>
	<div class="form-group">
		<label> tipo: </label>
		<select class="form-control" name="tipo">
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
		<a href="?" class="btn btn-default">Limpiar</a>
		<% if(usuario.contains("1")) { %><a href="Editar_Obra.jsp" class="btn btn-warning" style="float: right; margin-left: 20px;">Agregar Obra</a><% } %>
	</div>
</form>

<table class="table table-striped">
	<tr>
		<th>Imagen</th>
		<th>Título</th>
		<th>Autor</th>
		<th>Tipo de Obra</th>
	</tr>
	<%
		List<Obra> obras = Obra_BD.buscarObras(request.getParameter("busqueda"), tipoint);
		for (Obra obra : obras) {
	%>
	<tr>
		<%
			if (usuario == null || !usuario.contains("1")) {
		%>
		<td><a href="Ver_Obra.jsp?id=<%=obra.getIdObra()%>"><img width="100" src="<%=obra.getImagen()%>" /></a></td>
		
		<%
			} else  {
		%>
		<td><a href="Editar_Obra.jsp?id=<%=obra.getIdObra()%>"><img width="100" src="<%=obra.getImagen()%>" /></a></td>
		<%
			}
		%>
		<td><%=obra.getTitulo()%></td>
		<td><%=obra.getAutor()%></td>
		<td><%=obra.getTipoString()%></td>
	</tr>
	<%
		}
	%>
</table>

<jsp:include page="Footer.jsp" />