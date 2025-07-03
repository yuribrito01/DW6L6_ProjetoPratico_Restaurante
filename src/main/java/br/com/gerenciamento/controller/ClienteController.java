package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Cliente;
import br.com.gerenciamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Mapeamento para exibir o novo formulário de cliente
    @GetMapping("/clientes/novo")
    public ModelAndView novoCliente() {
        ModelAndView modelAndView = new ModelAndView("formCliente");
        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }

    // Ação para salvar o novo cliente (vindo do formCliente.html)
    @PostMapping("/clientes/salvar")
    public ModelAndView salvarCliente(@Valid Cliente cliente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Se houver erros, retorna para o formulário
            return new ModelAndView("formCliente");
        }
        clienteRepository.save(cliente);
        // Redireciona para uma página de listagem de clientes
        return new ModelAndView("redirect:/clientes");
    }

// Este método agora vai chamar a sua nova página listClientes.html
@GetMapping("/clientes")
public ModelAndView listarClientes() {
    ModelAndView modelAndView = new ModelAndView("listClientes");
    modelAndView.addObject("clientesList", clienteRepository.findAll());
    return modelAndView;
}

// Este método agora vai redirecionar os resultados da pesquisa para outra página
// que você pode criar ou adaptar, como a pesquisa-resultado.html
@PostMapping("/pesquisar-cliente")
public ModelAndView pesquisarCliente(@RequestParam(required = false) String nome) {
    ModelAndView modelAndView = new ModelAndView("listClientes"); // Mostra os resultados na mesma página
    List<Cliente> listaClientes;
    if(nome == null || nome.trim().isEmpty()) {
        listaClientes = clienteRepository.findAll();
    } else {
        listaClientes = clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
    modelAndView.addObject("clientesList", listaClientes);
    return modelAndView;
    }
    
    // As funções de editar e remover podem ser mantidas, mas aponte o redirect para /clientes
    @GetMapping("/clientes/editar/{id}")
    public ModelAndView editarCliente(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("formCliente"); // Reutiliza o formulário
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @GetMapping("/clientes/remover/{id}")
    public String removerCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}