package br.com.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repository.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;





@RestController
public class Controller {

    @Autowired
    private Repositorio acao;

    @GetMapping("/api")

    public List<Pessoa> mostrar(){
        return acao.findAll();
    }
    
    @GetMapping("/api/ordenanomes")

    public List<Pessoa> ordernaNome(){
        return acao.findByOrderByNome();
    }

    @GetMapping("api/ordernanomesiguais")
    public List <Pessoa> ordernaNomesIguais(){
        return acao.findByNomeOrderByIdadeDesc("Jorge");
    }

    @GetMapping("api/somaidades")
    public int somaIdades(){
        return acao.somaIdades();
    }

    @GetMapping("api/nomeconteudo")

    public List <Pessoa> nomeConteudoEspecifico(){
        return acao.findByNomeContaining("E");
    }

    @GetMapping("/api/iniciacom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("j");
    }
    @GetMapping("/api/terminacom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("a");
    }

    @GetMapping("/api/{codigo}")

    public Pessoa acharCodigo(@PathVariable int codigo){
        return acao.findBycodigo(codigo);
    }
    
    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @PutMapping("/api")

    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @DeleteMapping("/api/{codigo}")

    public void remover(@PathVariable int codigo){
        Pessoa obj = acao.findBycodigo(codigo);

        acao.delete(obj);

    }

    @GetMapping("api/contador")

    public long contador(){
        return acao.count();

    }

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
    
    @GetMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p ){
        return p;
    }
    
    
}
