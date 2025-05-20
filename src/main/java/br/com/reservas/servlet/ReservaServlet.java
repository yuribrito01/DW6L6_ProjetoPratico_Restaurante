package br.com.reservas.servlet;

import br.com.reservas.dao.ReservaDao;
import br.com.reservas.model.Reserva;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int clienteId = Integer.parseInt(request.getParameter("clienteId"));
            int mesaId = Integer.parseInt(request.getParameter("mesaId"));
            LocalDateTime dataHora = LocalDateTime.parse(request.getParameter("dataHora"));

            Reserva reserva = new Reserva(clienteId, mesaId, dataHora);
            ReservaDao dao = new ReservaDao();
            dao.inserir(reserva);

            response.sendRedirect("reserva.jsp?sucesso=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reserva.jsp?erro=true");
        }
    }
}
