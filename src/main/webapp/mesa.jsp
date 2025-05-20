<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Cadastro de Mesa</title>
</head>
<body>
	<h2>Cadastro de Mesa</h2>
	
	<form action="mesa" method="post">
		<label>Numero:</label>
		<input type="number" name="numero" required><br><br>
		
		<label>Capacidade:</label>
		<input type="number" name="capacidade" required><br><br>
		
		<input type="submit" value="Cadastrar">
	</form>

</body>
</html>