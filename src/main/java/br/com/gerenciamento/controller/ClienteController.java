package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Cliente;
import br.com.gerenciamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes") // Define "/api/clientes" como a URL base para este controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // GET /api/clientes - Lista todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // GET /api/clientes/{id} - Busca um cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok) // Se encontrar, retorna o cliente com status 200 OK
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // GET /api/clientes/pesquisar?nome=... - Busca clientes por nome
    @GetMapping("/pesquisar")
    public List<Cliente> pesquisarPorNome(@RequestParam String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    // POST /api/clientes - Cria um novo cliente
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") // Apenas usuários com perfil ADMIN podem criar
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED); // Retorna o cliente criado com status 201 Created
    }

    // PUT /api/clientes/{id} - Atualiza um cliente existente
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") // Apenas ADMINs podem atualizar
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(clienteAtualizado.getNome());
                    clienteExistente.setEmail(clienteAtualizado.getEmail());
                    clienteExistente.setTelefone(clienteAtualizado.getTelefone());
                    clienteExistente.setFuncao(clienteAtualizado.getFuncao());
                    Cliente salvo = clienteRepository.save(clienteExistente);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/clientes/{id} - Deleta um cliente
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") // Apenas ADMINs podem deletar
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}