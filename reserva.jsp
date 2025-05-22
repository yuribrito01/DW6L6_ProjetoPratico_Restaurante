<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.reservas.model.Cliente" %>
<%@ page import="br.com.reservas.model.Mesa" %>
<%@ page import="br.com.reservas.dao.ClienteDao" %>
<%@ page import="br.com.reservas.dao.MesaDao" %>

<%
    ClienteDao clienteDao = new ClienteDao();
    MesaDao mesaDao = new MesaDao();

    List<Cliente> clientes = clienteDao.listarTodos();
    List<Mesa> mesas = mesaDao.listarTodos();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Nova Reserva</title>
    <!-- Flatpickr CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <!-- Flatpickr JS -->
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
	<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/plugins/scrollPlugin.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
	   
</head>
<body>

<div class="container py-5 d-flex justify-content-center">
    <div class="w-100" style="max-width: 400px;">
        <form action="reserva" method="post" class="p-4 bg-white rounded shadow-sm">
            <h2 class="mb-4 text-center fw-light">Nova Reserva</h2>

            <div class="mb-3">
                <label for="cliente" class="form-label small">Cliente:</label>
                <select id="cliente" name="clienteId" class="form-select form-select-sm" required>
                    <option value="">Selecione</option>
                    <% for (Cliente c : clientes) { %>
                        <option value="<%= c.getId() %>"><%= c.getNome() %></option>
                    <% } %>
                </select>
            </div>

            <div class="mb-3">
                <label for="mesa" class="form-label small">Mesa:</label>
                <select id="mesa" name="mesaId" class="form-select form-select-sm" required>
                    <option value="">Selecione</option>
                    <% for (Mesa m : mesas) { %>
                        <option value="<%= m.getId() %>">Mesa <%= m.getNumero() %> (Cadeiras: <%= m.getCapacidade() %>)</option>
                    <% } %>
                </select>
            </div>

            <div class="mb-3">
                <label for="dataHora" class="form-label small">Data e Hora:</label>
                <input type="datetime-local" id="dataHora" name="dataHora"
                       class="form-control form-control-sm" required onkeydown="return false;">
            </div>

            <div class="text-end">
                <button type="submit" class="btn btn-dark btn-sm px-3">Confirmar</button>
            </div>
        </form>
    </div>
</div>


<script>
    flatpickr("#dataHora", {
        enableTime: true,
        dateFormat: "Y-m-d H:i", // com espaço entre data e hora
        time_24hr: true,
        minuteIncrement: 15,
        allowInput: false, // impede digitação manual
        minDate: "today", // bloqueia datas passadas
        plugins: [new scrollPlugin()]
    });
</script>
<%
    String sucesso = request.getParameter("sucesso");
%>
<% if ("true".equals(sucesso)) { %>
    <div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
        <div id="sucessoToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    ✅ Reserva feita com sucesso!
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
