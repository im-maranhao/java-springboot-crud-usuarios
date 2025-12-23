package br.com.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // 🔥 Permite acessos do front no XAMPP
public class MensagemController {

    @GetMapping("/api/mensagem")
    public Map<String, String> mensagem(){
        return Map.of("mensagem", "Olá do backend Java!");
    }
}

