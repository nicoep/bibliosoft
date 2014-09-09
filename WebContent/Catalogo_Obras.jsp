<%@page import="datos.Obra_BD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Obra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catálogo de Obras</title>
</head>
<body>
<%if (session.getAttribute("obras_disponibles") != null) {
	ArrayList<Obra> obras = (ArrayList<Obra>) session.getAttribute("obras_disponibles");
	%>
	<table border="1">
		<tr>
			<th>idObra</th>
			<th>Título</th>
			<th>Autor</th>
			<th>Editorial</th>
			<th>C.D.U.</th>
			<th>I.S.B.N.</th>
			<th>Imagen</th>
			<th>Descriptores</th>
			<th>Stock</th>
			<th>Tipo de Obra</th>
		</tr>
		<% for (Obra o : obras) { %>
		<tr>
			<td><%= o.getIdObra() %></td>
			<td><%= o.getTitulo() %></td>
			<td><%= o.getAutor() %></td>
			<td><%= o.getEditorial() %></td>
			<td><%= o.getCdu() %></td>
			<td><%= o.getIsbn() %></td>
			<td><%= o.getImagen() %>
			<td><%= o.getDescriptores() %></td>
			<td><%= o.getStock() %></td>
			<td><%= o.getIdTipo() %></td>
		</tr>
		<% }
		%>
	</table>
	<% } %>

</body>
</html>