package br.com.projeto.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.Cliente;
import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repositories.Repositorio;
import br.com.projeto.api.services.Servico;

@RestController
public class Controle {

  @Autowired
  private Repositorio acao;

  @Autowired
  private Servico servico;

  // Endpoint para CADASTRAR Pessoas
  @PostMapping("/api")
  public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj) {
    return servico.cadastrar(obj);

  }

  // Endpoint para SELECIONAR Pessoas
  @GetMapping("/api")
  public ResponseEntity<?> selecionar() {
    return servico.selecionar();

  }

  // Endpoint para SELECIONAR Pelo Código
  @GetMapping("api/{codigo}")
  public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) {
    return servico.selecionarPeloCodigo(codigo);
  }

  // Endpoint para Editar pessoas e idade
  @PutMapping("/api")
  public ResponseEntity<?> editar(@RequestBody Pessoa obj) {
    return servico.editar(obj);
  }

  // Endpoint de remover pessoas e idade
  @DeleteMapping("/api/{codigo}")
  public ResponseEntity<?> remover(@PathVariable int codigo) {
    return servico.remover(codigo);
  }

  @GetMapping("/api/contador")
  public long contador() {
    return acao.count();
  }

  @GetMapping("/api/ordenarNomes")
  public List<Pessoa> ordenarNome() {
    return acao.findByOrderByNome();
  }

  @GetMapping("/api/ordenarNomes2")
  public List<Pessoa> ordenarNomes2() {
    return acao.findByNomeOrderByIdadeDesc("Pense");
  }

  @GetMapping("/api/nomeContem")
  public List<Pessoa> nomeContem() {
    return acao.findByNomeContaining("M");
  }

  @GetMapping("/api/iniciaCom")
  public List<Pessoa> inciaCom() {
    return acao.findByNomeStartsWith("a");
  }

  @GetMapping("/api/terminaCom")
  public List<Pessoa> terminaCom() {
    return acao.findByNomeEndsWith("a");
  }

  @GetMapping("/api/somaIdades")
  public int somaIdades() {
    return acao.somaIdades();
  }

  @GetMapping("/api/idadeMenorIgual")
  public List<Pessoa> idadeMaiorIgual() {
    return acao.idadeMenorIgual(16);
  }

  @GetMapping("")
  public String mensagem() {
    return "Olá Mundo"; 
  }

  @GetMapping("/boasVindas/{nome}")
  public String boasVindas(@PathVariable String nome) {
    return "Seja Bem Vindo(a)" + nome;
  }

  @PostMapping("/pessoa")
  public Pessoa  pessoa(@RequestBody Pessoa pessoa) {
   return pessoa;
  }

  @GetMapping("/status")
  public ResponseEntity<?> status() {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/cliente")
  public void cliente(@Valid @RequestBody Cliente obj) {

  }
  
}
