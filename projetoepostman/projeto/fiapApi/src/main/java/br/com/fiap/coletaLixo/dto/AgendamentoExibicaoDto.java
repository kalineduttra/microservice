package br.com.fiap.coletaLixo.dto;

import br.com.fiap.coletaLixo.model.Agendamento;
import br.com.fiap.coletaLixo.model.StatusColeta;
import java.time.LocalDate;

public record AgendamentoExibicaoDto(
     Long id,
     String endereco,
     LocalDate data,
     String cliente,
     StatusColeta statusColeta
) {

  public AgendamentoExibicaoDto(Agendamento agendamento){
    this(
        agendamento.getId(),
        agendamento.getEndereco(),
        agendamento.getData(),
        agendamento.getCliente(),
        agendamento.getStatusColeta()
        );
  }
}
