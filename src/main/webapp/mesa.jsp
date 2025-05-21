<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.reservas.model.Mesa" %>
<%@ page import="br.com.reservas.dao.MesaDao" %>
<%@ page import="br.com.reservas.model.Reserva" %>
<%@ page import="br.com.reservas.dao.ReservaDao" %>

<%
    MesaDao mesaDao = new MesaDao();
    ReservaDao reservaDao = new ReservaDao();

    List<Mesa> mesas = mesaDao.listarTodos();
    List<Reserva> reservas = reservaDao.listarTodas();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Mesa</title>
    <link rel="stylesheet" href="css/style.css">  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">         
</head>
<body>

<div class="container py-5 d-flex justify-content-center">
    <div class="w-100" style="max-width: 800px;">
    	<h4 class="mb-4 text-center fw-light">Nova Mesa</h4>
    	<div class="mx-auto" style="max-width: 300px;">
    		<form action="mesa" method="post" class="mb-4">
                
                <div class="mb-3">
                    <label for="numero" class="form-label small">Número da Mesa</label>
                    <input type="number" class="form-control form-control-sm" id="numero" name="numero" required>
                </div>

                <div class="mb-3">
                    <label for="capacidade" class="form-label small">Capacidade de Pessoas</label>
                    <input type="number" class="form-control form-control-sm" id="capacidade" name="capacidade" required>
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-dark btn-sm">Salvar</button>
                </div>
            </form>
    	
    	</div>
        <div class="p-4 mb-4 bg-white rounded shadow-sm">
            
            <h5 class="mb-3 fw-semibold text-secondary">Mesas Cadastradas</h5>
            <div class="table-responsive mb-5">
                <table class="table table-bordered table-hover align-middle table-sm">
                    <thead class="table-light small">
                        <tr>
                            <th>ID</th>
                            <th>Número</th>
                            <th>Capacidade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Mesa m : mesas) { %>
                        <tr>
                            <td><%= m.getId() %></td>
                            <td><%= m.getNumero() %></td>
                            <td><%= m.getCapacidade() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>

            <h5 class="mb-3 fw-semibold text-secondary">Reservas Cadastradas</h5>
            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle table-sm">
                    <thead class="table-light small">
                        <tr>
                            <th>ID</th>
                            <th>Cliente</th>
                            <th>Mesa</th>
                            <th>Data e Hora</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Reserva r : reservas) { %>
                        <tr>
                            <td><%= r.getId() %></td>
                            <td><%= r.getCliente() %></td>
                            <td><%= r.getMesa() %></td>
                            <td><%= r.getDataHora() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



<%
    String sucesso = request.getParameter("sucesso");
%>
<% if ("true".equals(sucesso)) { %>
    <div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
        <div id="sucessoToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    ✅ Mesa cadastrada com sucesso!
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Fechar"></button>
            </div>
        </div>
    </div>
<% } %>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const toastEl = document.getElementById('sucessoToast');
        if (toastEl) {
            const toast = new bootstrap.Toast(toastEl, { delay: 3000 });
            toast.show();
        }
    });
</script>
</body>
</html>

