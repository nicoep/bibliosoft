<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliosoft Login</title>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="jquery-1.11.1.min.js"></script>
<script src="bootstrap.js"></script>
</head>
<body>
	<center style="margin-top: 100px">
		<div style="width: 280px; padding: 10px;">
			<center>
				<h3>Error</h3>
				<div style="color: red;">
					<p>Limite de obras permitidas retiradas. Disculpe las
						molestias.</p>
					<p>El socio no puede tener mas de dos obras retiradas
						pendientes.</p>
				</div>

				<div class="form-group">
					<a href="Home.jsp" class="btn btn-success">Aceptar</a>
				</div>
		</div>
	</center>
	<jsp:include page="Footer.jsp" />