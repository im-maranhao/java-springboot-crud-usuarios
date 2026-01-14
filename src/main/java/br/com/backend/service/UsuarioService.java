package br.com.backend.service;

import br.com.backend.model.Usuario;
import  br.com.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }

    public Usuario salvar(Usuario u){
        return repo.save(u);
    }

    public Optional<Usuario> buscarPorEmail(String email){
        return repo.findByEmail(email);
    }

    public boolean login(String email, String senha) {
        return repo.findByEmail(email)
                .map(u -> u.getSenha().equals(senha))
                .orElse(false);
    }

    public Iterable<Usuario> listar(){
        return repo.findAll();
    }

    public void excluir(Long id){
        repo.deleteById(id);

    }
}
