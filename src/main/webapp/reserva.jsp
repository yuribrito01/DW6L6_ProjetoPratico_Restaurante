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
    <link rel="stylesheet" href="css/style.css">
    <!-- Flatpickr CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <!-- Flatpickr JS -->
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
	<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/plugins/scrollPlugin.js"></script>
	   
</head>
<body>

<div class="container">
    <h2>Fazer Reserva</h2>

    <form action="reserva" method="post">
        <label for="cliente">Cliente:</label>
        <select id="cliente" name="clienteId" required>
            <option value="">Selecione</option>
            <% for (Cliente c : clientes) { %>
                <option value="<%= c.getId() %>"><%= c.getNome() %></option>
            <% } %>
        </select>

        <label for="mesa">Mesa:</label>
        <select id="mesa" name="mesaId" required>
            <option value="">Selecione</option>
            <% for (Mesa m : mesas) { %>
                <option value="<%= m.getId() %>">Mesa <%= m.getNumero() %> (Cap: <%= m.getCapacidade() %>)</option>
            <% } %>
        </select>

        <label for="dataHora">Data e Hora da Reserva:</label>
		<input type="text" id="dataHora" name="dataHora" required onkeydown="return false;">

        <input type="submit" value="Confirmar Reserva">
    </form>
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

</body>
</html>

