package br.com.fiap.coletaLixo.service;


import br.com.fiap.coletaLixo.model.Coleta;
import br.com.fiap.coletaLixo.repository.ColetaRespository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColetaService {
  @Autowired
  private ColetaRespository coletaRespository;

  public Optional<Coleta> getColetaById (Long id){
     Optional <Coleta> getColeta = coletaRespository.findById(id);
    return getColeta;
  }


  public List<Coleta> listarColetas() {
    return coletaRespository.findAll();
  }
}

