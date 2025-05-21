<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Mesa</title>
    <link rel="stylesheet" href="css/style.css">           
</head>
<body>

<div class="container">
    <h2>Cadastro de Mesa</h2>

    <form action="mesa" method="post">
        <label for="numero">Número da Mesa:</label>
        <input type="number" id="numero" name="numero" required>

        <label for="capacidade">Capacidade de pessoas:</label>
        <input type="number" id="capacidade" name="capacidade" required>

        <input type="submit" value="Salvar">
    </form>
</div>

</body>
</html>
