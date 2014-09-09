<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalogo</title>
</head>
<body>
	<div>
		<h1>Catalogo</h1>
	</div>
	<div>
		<h3>Nueva Obra</h3>
		<form action="alta_obra" method="post">
			<p><label>Título:</label><input name="titulo"></p>
			<p><label>Autor:</label><input name="autor"></p>
			<p><label>Editorial:</label><input name="editorial"></p>
			<p><label>C.D.U.:</label><input name="cdu"></p>
			<p><label>I.S.B.N.:</label><input name="isbn"></p>
			<p><label>Stock:</label><input name="stock"></p>
			<p><label>Tipo de Obra:</label><input name="tipoObra"></p>
			
			<p><input type="submit" value="Alta"></p>
		</form>
	</div>
</body>
</html>