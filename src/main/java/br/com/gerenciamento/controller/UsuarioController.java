package br.com.gerenciamento.controller;

import br.com.gerenciamento.repository.UsuarioRepository;
import br.com.gerenciamento.exception.EmailExistsException;
import br.com.gerenciamento.exception.ServiceExc;
import br.com.gerenciamento.model.Cliente;
import br.com.gerenciamento.model.Usuario;
import br.com.gerenciamento.service.ServiceUsuario;
import br.com.gerenciamento.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.gerenciamento.dtos.RegisterDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("cadastro");
        return modelAndView;
    }

@PostMapping("/salvarUsuario")
    public ModelAndView cadastrar(@Valid RegisterDTO data, BindingResult result) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("cadastro");
            modelAndView.addObject("usuario", data);
            return modelAndView;
        }

        try {
            serviceUsuario.salvarUsuario(data);
            modelAndView.setViewName("redirect:/");
        } catch (EmailExistsException e) {
            modelAndView.setViewName("cadastro");
            modelAndView.addObject("usuario", data);
            modelAndView.addObject("msg", e.getMessage());
        }

        return modelAndView;
    }


    @PostMapping("/login")
    public ModelAndView login(@Valid Usuario usuario, BindingResult br,
                              HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        if(br.hasErrors()) {
            modelAndView.setViewName("login");
        }

        Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
        if(userLogin == null) {
            modelAndView.addObject("msg","Usuario não encontrado. Tente novamente");
        } else {
            session.setAttribute("usuarioLogado", userLogin);
            return index();
        }

        return modelAndView;
    }

    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return login();
    }
}