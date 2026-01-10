package br.com.backend.controller;

import br.com.backend.model.Usuario;
import br.com.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }
    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return service.salvar(usuario);
    }

    @PostMapping("/login")

    public Map<String, Object> login(@RequestBody Map<String, String> req){
        boolean ok = service.login(req.get("email"), req.get("senha"));
        return Map.of("sucesso", ok);
    }

    @GetMapping
    public Iterable<Usuario> listar(){
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}