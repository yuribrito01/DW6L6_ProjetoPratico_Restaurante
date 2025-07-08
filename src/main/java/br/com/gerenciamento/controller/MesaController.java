package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Mesa;
import br.com.gerenciamento.repository.MesaRepository;
import br.com.gerenciamento.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/mesas")
    public ModelAndView gerenciarMesas() {
        ModelAndView modelAndView = new ModelAndView("gerenciarMesas");
        modelAndView.addObject("mesaParaSalvar", new Mesa());
        modelAndView.addObject("listaDeMesas", mesaRepository.findAll());
        modelAndView.addObject("listaDeReservas", reservaRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/mesas/salvar")
    public String salvarMesa(Mesa mesa) {
        mesaRepository.save(mesa);
        return "redirect:/mesas";
    }
}