package br.com.reservas.servlet;
import java.io.IOException;

import br.com.reservas.model.Mesa;

import br.com.reservas.dao.MesaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mesa")
public class MesaServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		int numero = Integer.parseInt(request.getParameter("numero"));
	    int capacidade = Integer.parseInt(request.getParameter("capacidade"));
      
        Mesa mesa = new Mesa(numero, capacidade);
        MesaDao dao = new MesaDao();
        dao.inserir(mesa);

        response.sendRedirect("mesa.jsp?sucesso=true");
    }
}
