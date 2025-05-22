<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>

<div class="container py-5 d-flex justify-content-center">
    <div class="w-100" style="max-width: 400px;">
        <form action="cliente" method="post" class="p-4 bg-white rounded shadow-sm">
            <h2 class="mb-4 text-center fw-light">Cadastro de Cliente</h2>

            <div class="mb-3">
                <label class="form-label small">Nome:</label>
                <input type="text" class="form-control form-control-sm" name="nome" required>
            </div>

            <div class="mb-3">
                <label class="form-label small">E-mail:</label>
                <input type="email" class="form-control form-control-sm" name="email" required>
            </div>

            <div class="mb-3">
                <label class="form-label small">Telefone:</label>
                <input type="text" class="form-control form-control-sm" name="telefone" required>
            </div>

            <div class="mb-3">
                <label class="form-label small" for="tipo">Função:</label>
                <select id="tipo" name="tipo" class="form-select form-select-sm" required>
                    <option value="">Selecione</option>
                    <option value="cliente">Cliente</option>
                    <option value="admin">Administrador</option>
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
