package br.com.reservas.servlet;

import br.com.reservas.dao.ClienteDao;
import br.com.reservas.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet{
	

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String tipo = request.getParameter("tipo");

        Cliente cliente = new Cliente(nome, email, telefone, tipo);
        ClienteDao dao = new ClienteDao();
        dao.inserir(cliente);
        
        if ("admin".equals(tipo)) {
            response.sendRedirect("mesa.jsp");
        } else if ("cliente".equals(tipo)) {
            response.sendRedirect("reserva.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }

    }

}
