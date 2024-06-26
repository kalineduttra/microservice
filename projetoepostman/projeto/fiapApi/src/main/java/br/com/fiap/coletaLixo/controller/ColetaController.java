package br.com.fiap.coletaLixo.controller;


import br.com.fiap.coletaLixo.model.Coleta;
import br.com.fiap.coletaLixo.service.ColetaService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColetaController {
  @Autowired
  private ColetaService service;

  @GetMapping("/helloword")
  public String hellowrod(){
      String helou = "Hello word";
    return helou;
  }

  @GetMapping("/coletas")
  public ResponseEntity<List<Coleta>> listarColetas() {
    try {
      List<Coleta> coletas = service.listarColetas();
      return ResponseEntity.ok(coletas);
    }catch (
        Exception e
    ) {
      return (ResponseEntity<List<Coleta>>) ResponseEntity.badRequest();
    }

  }
  
  @GetMapping("/coletas/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<Coleta> buscarPorId(@PathVariable Long id){
    Optional<Coleta> coletaById = service.getColetaById(id);
    return coletaById;
  }



}
