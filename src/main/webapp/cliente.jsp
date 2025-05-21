<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
<h2>Cadastro de Cliente</h2>

<% 
    String sucesso = request.getParameter("sucesso");
    if ("true".equals(sucesso)) {
%>
    <p style="color:green;">Cliente cadastrado com sucesso!</p>
<% 
    }
%>

<form action="cliente" method="post">
    <label>Nome:</label>
    <input type="text" name="nome" required>

    <label>E-mail:</label>
    <input type="email" name="email" required>

    <label>Telefone:</label>
    <input type="text" name="telefone" required>

    <input type="submit" value="Cadastrar">
</form>
</div>

</body>
</html>
