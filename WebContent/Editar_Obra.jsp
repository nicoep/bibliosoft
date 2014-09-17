<%@page import="java.util.Map.Entry"%>
<%@page import="entidades.TipoObra"%>
<%@page import="datos.Obra_BD"%>
<%@page import="entidades.Obra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />

<%
	String idObra = request.getParameter("id");
	Obra obra = idObra == null ? null : Obra_BD.get_obra(Integer.valueOf(idObra));
%>

<center>
	<h3>Formulario Obra <%= (obra == null ? "" : obra.getIdObra()) %> </h3>
</center>

<% if (obra == null) { %>
	<form action="alta_obra" method="post" class="form-horizontal">
<% } else { %>
	<form action="modifica_obra" method="post" class="form-horizontal">
<% } %>
   <input class="form-control" name="id" value="<%= (obra == null ? "" : obra.getIdObra()) %>" type="hidden">

	<div class="form-group">
		<label class="col-sm-3 control-label">Título:</label>
		<div class="col-sm-6">
			<input class="form-control" name="titulo" value="<%= (obra == null ? "" : obra.getTitulo()) %>">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Autor:</label>
		<div class="col-sm-6">
			<input class="form-control" name="autor" value="<%= (obra == null ? "" : obra.getAutor()) %>" >
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Editorial:</label>
		<div class="col-sm-6">
			<input class="form-control" name="editorial" value="<%= (obra == null ? "" : obra.getEditorial()) %>">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">C.D.U.:</label>
		<div class="col-sm-6">
			<input class="form-control" name="cdu" value="<%= (obra == null ? "" : obra.getCdu()) %>">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">I.S.B.N.:</label>
		<div class="col-sm-6">
			<input class="form-control" name="isbn" value="<%= (obra == null ? "" : obra.getIsbn()) %>">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Imagen</label>
		<div class="col-sm-6">
			<input class="form-control" name="imagen" value="<%= (obra == null ? "" : obra.getImagen()) %>">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Stock:</label>
		<div class="col-sm-6">
			<input class="form-control" name="stock" value="<%= (obra == null ? "" : obra.getStock()) %>">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Tipo de Obra:</label>
		<div class="col-sm-6">
			<select name="tipoObra" class="form-control">
				<%
				for (int n = 1; n < 6; n++) {
					if (obra!=null && obra.getIdObra() == n) {
						%>
						<option selected value="<%= n %>"><%=TipoObra.opciones.get(n) %></option>
						<%
					} else { 
					%>
					<option value="<%= n %>"><%=TipoObra.opciones.get(n) %></option>
					<%
					}
				}
				%>
			</select>
		</div>
	</div>

	<div class="form-group" style="text-align: center">
		<a href="/bibliosoft/" class="btn btn-danger">Volver</a>
		<% if (obra == null) { %>
		<input type="submit" value="Crear" name="action" class="btn btn-success">
		<% } else { %>
		<input type="submit" value="Eliminar" name="action" class="btn btn-danger">
		<input type="submit" value="Modificar" name="action" class="btn btn-success">
		<% } %>
	</div>
	
</form>
<jsp:include page="Footer.jsp" />