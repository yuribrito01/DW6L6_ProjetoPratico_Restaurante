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
</head>
<body>

<h2>Fazer Reserva</h2>

<form action="reserva" method="post">
    <label>Cliente:</label><br>
    <select name="clienteId" required>
        <option value="">Selecione</option>
        <% for (Cliente c : clientes) { %>
            <option value="<%= c.getId() %>"><%= c.getNome() %></option>
        <% } %>
    </select><br><br>

    <label>Mesa:</label><br>
    <select name="mesaId" required>
        <option value="">Selecione</option>
        <% for (Mesa m : mesas) { %>
            <option value="<%= m.getId() %>">Mesa <%= m.getNumero() %> (Cap: <%= m.getCapacidade() %>)</option>
        <% } %>
    </select><br><br>

    <label>Data e HoraS da Reserva:</label><br>
    <input type="datetime-local" name="dataHora" required><br><br>

    <input type="submit" value="Confirmar Reserva">
</form>

</body>
</html>
