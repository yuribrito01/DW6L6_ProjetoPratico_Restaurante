<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
</head>
<body>

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
    <label>Nome:</label><br>
    <input type="text" name="nome" required><br><br>

    <label>E-mail:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Telefone:</label><br>
    <input type="text" name="telefone" required><br><br>

    <input type="submit" value="Cadastrar">
</form>

</body>
</html>
