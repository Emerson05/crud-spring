package br.com.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repository.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
public class Controller {

    @Autowired
    private Repositorio acao;
    @GetMapping("")
    public String mensagem() {
        return "Hellow World";
    }

    @GetMapping("/boasvindas/")
    public String BoasVindas() {
        return "Boas Vindas " ;
    }
    

    @GetMapping("/boasvindas/{nome}")
    public String BoasVindas(@PathVariable String nome) {
        return "Boas Vindas " + nome;
    }

    @PostMapping("/pessoa")
    public String postMethodName(@RequestBody String entity) {
        
        return entity;
    }
    
    public Pessoa pessoa(@RequestBody Pessoa p ){
        return p;
    }
    
    
}
