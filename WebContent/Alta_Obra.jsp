<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<center>
	<h3>Formulario Obra</h3>
</center>
<form action="alta_obra" method="post" class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-3 control-label">Título:</label>
		<div class="col-sm-6">
			<input class="form-control" name="titulo">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Autor:</label>
		<div class="col-sm-6">
			<input class="form-control" name="autor">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Editorial:</label>
		<div class="col-sm-6">
			<input class="form-control" name="editorial">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">C.D.U.:</label>
		<div class="col-sm-6">
			<input class="form-control" name="cdu">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">I.S.B.N.:</label>
		<div class="col-sm-6">
			<input class="form-control" name="isbn">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Imagen</label>
		<div class="col-sm-6">
			<input class="form-control" name="imagen">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Stock:</label>
		<div class="col-sm-6">
			<input class="form-control" name="stock">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Tipo de Obra:</label>
		<div class="col-sm-6">
			<select name="tipoObra" class="form-control">
				<option value="1">Libro</option>
				<option value="2">Revista</option>
				<option value="3">Tesis</option>
				<option value="4">Norma</option>
				<option value="5">Proyecto</option>
			</select>
		</div>
	</div>

	<div class="form-group" style="text-align: center">
		<a href="/bibliosoft/" class="btn btn-danger">Volver</a>
		<button type="submit" class="btn btn-success">Guardar</button>

	</div>
</form>
<jsp:include page="Footer.jsp" />