package br.com.gerenciamento.service;

import br.com.gerenciamento.dtos.RegisterDTO;
import br.com.gerenciamento.exception.EmailExistsException;
import br.com.gerenciamento.model.Usuario;
import br.com.gerenciamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvarUsuario(RegisterDTO data) throws EmailExistsException {
        if (this.usuarioRepository.findByEmail(data.email()) != null) {
            throw new EmailExistsException("Este email já está cadastrado: " + data.email());
        }

        String encryptedPassword = passwordEncoder.encode(data.senha());
        
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(data.email());
        novoUsuario.setUser(data.user());
        novoUsuario.setSenha(encryptedPassword); 
        novoUsuario.setRole(data.role()); 

        this.usuarioRepository.save(novoUsuario);
    }
}