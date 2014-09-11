<%@page import="entidades.Obra"%>
<%@page import="datos.Obra_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<%
	Obra obra = new Obra_BD().get_obra(Integer.valueOf(request
			.getParameter("id")));
%>
<center>
	<h3><%=obra.getTitulo()%></h3>
</center>
<form action="alta_obra" method="post" class="form-horizontal">
	<div class="form-group">
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
			<label class="control-label"><%=obra.getCdu()%></label>
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
			<label class="control-label"><%=obra.getStock()%></label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Tipo de Obra:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getTipoString()%></label>
		</div>
	</div>

	<div class="form-group" style="text-align: center">
		<button type="submit" class="btn btn-primary">Reservar</button>
	</div>
</form>
<jsp:include page="Footer.jsp" />