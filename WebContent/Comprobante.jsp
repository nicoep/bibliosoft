<%@page import="entidades.Obra"%>
<%@page import="datos.Obra_BD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<%
	Obra obra = Obra_BD.get_obra(Integer.valueOf(request
			.getParameter("id")));
%>
<center>
	<h3>"Comprobante de Reserva"</h3>
	<p>Presentar este comprobante para retirar su pedido</p>
</center>
<form action="" method="post" class="form-horizontal">

	<div class="form-group">
		<label class="col-sm-3 control-label">Id de Obra:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getIdObra()%></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label">Titulo:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getTitulo()%></label>
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
		<label class="col-sm-3 control-label">Tipo de Obra:</label>
		<div class="col-sm-6">
			<label class="control-label"><%=obra.getTipoString()%></label>
		</div>
	</div>

	<div class="form-group" style="text-align: center">
		<a href="Home.jsp" class="btn btn-success">Finalizar</a>
	</div>

</form>
<jsp:include page="Footer.jsp" />