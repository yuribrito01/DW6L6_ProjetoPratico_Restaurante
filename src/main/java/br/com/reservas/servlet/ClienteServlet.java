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

        Cliente cliente = new Cliente(nome, email, telefone);
        ClienteDao dao = new ClienteDao();
        dao.inserir(cliente);

        response.sendRedirect("cliente.jsp?sucesso=true");
    }

}
