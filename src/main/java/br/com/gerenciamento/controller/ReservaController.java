package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Reserva;
import br.com.gerenciamento.repository.ClienteRepository;
import br.com.gerenciamento.repository.MesaRepository;
import br.com.gerenciamento.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @GetMapping("/reservas/nova")
    public ModelAndView novaReserva() {
        ModelAndView modelAndView = new ModelAndView("formReserva");
        modelAndView.addObject("reserva", new Reserva());
        modelAndView.addObject("listaDeClientes", clienteRepository.findAll());
        modelAndView.addObject("listaDeMesas", mesaRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/reservas/salvar")
    public String salvarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/mesas"; // Redireciona para a tela de gerenciamento de mesas para ver a reserva
    }
}