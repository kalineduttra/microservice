package br.com.fiap.coletaLixo.dto;

import br.com.fiap.coletaLixo.model.StatusColeta;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoDto {
  private Long id;
  private String endereco;
  private LocalDate data;
  private String cliente;
  private StatusColeta statusColeta;
}
