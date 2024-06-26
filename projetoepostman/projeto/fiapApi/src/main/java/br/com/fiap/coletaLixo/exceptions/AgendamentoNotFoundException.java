package br.com.fiap.coletaLixo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AgendamentoNotFoundException extends RuntimeException {

  public AgendamentoNotFoundException(String mensagem){
    super(mensagem);
  }
}
