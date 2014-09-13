<%@page import="entidades.Obra"%>
<%@page import="datos.Obra_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<%
	Obra obra = new Obra_BD().get_obra(Integer.valueOf(request.getParameter("id")));
%>
<center>
	<h3><%=obra.getTitulo()%></h3>
</center>
<form action="modifica_obra" method="post" class="form-horizontal">
	<div class="form-group">
		<div class="form-group">
		<label class="col-sm-3 control-label">Id de Obra:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=obra.getIdObra()%>" name="idObra" style="text-align: left; font-weight: bold;" readonly="readonly">
		</div>
	</div>
		<label class="col-sm-3 control-label">Imagen</label>
		<div class="col-sm-6">
			<img src="<%=obra.getImagen()%>" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Autor:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getAutor()%></label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Editorial:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getEditorial()%></label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">C.D.U.:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=obra.getCdu()%>" name="cdu" style="text-align: left; font-weight: bold;">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">I.S.B.N.:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getIsbn()%></label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Stock:</label>
		<div class="col-sm-6">
			<input type="text" class="control-label" value="<%=obra.getStock()%>" name="stock" style="text-align: left; font-weight: bold;">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Tipo de Obra:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getTipoString()%></label>
		</div>
	</div>

	<div class="form-group" style="text-align: center">
		<a href="/bibliosoft/" class="btn btn-danger">Volver</a>
		<a href="/bibliosoft/" class="btn btn-danger">Eliminar</a>
		<button type="submit" class="btn btn-success">Modificar</button>
	</div>
</form>
<jsp:include page="Footer.jsp" />