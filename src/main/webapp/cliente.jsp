<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>

<div class="container py-5 d-flex justify-content-center">
	<div class="w-100" style="max-width: 400px;">
		<h2>Cadastro</h2>
		<form action="cliente" method="post">
		    <label>Nome:</label>
		    <input type="text" name="nome" required>
		
		    <label>E-mail:</label>
		    <input type="email" name="email" required>
		
		    <label>Telefone:</label>
		    <input type="text" name="telefone" required>
		    <div class="mb-3">
			     <label for="tipo">Função:</label>
			    <select id="tipo" name="tipo">
			     <option value="">Selecione</option>
			     <option value="cliente">Cliente</option>
			     <option value="admin">Adiminidrador</option>
			    </select>
		    </div>		
		    <div class="text-end">
		    	<button type="submit" class="btn btn-dark btn-sm px-3">Cadastrar</button>
		    </div>
		</form>
	</div>
</div>

</body>
</html>
