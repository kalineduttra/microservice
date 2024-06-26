package br.com.fiap.coletaLixo.service;

import br.com.fiap.coletaLixo.dto.AgendamentoDto;
import br.com.fiap.coletaLixo.dto.AgendamentoExibicaoDto;
import br.com.fiap.coletaLixo.exceptions.AgendamentoNotFoundException;
import br.com.fiap.coletaLixo.model.Agendamento;
import br.com.fiap.coletaLixo.model.StatusColeta;
import br.com.fiap.coletaLixo.repository.AgendamentoRespository;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
  @Autowired
  private AgendamentoRespository agendamentoRespository;

  public List<Agendamento> listarAgendamentos() {
    return agendamentoRespository.findAll();
  }
  public AgendamentoExibicaoDto criarAgendamento(AgendamentoDto agendamentoDto) {
      Agendamento agendamento = new Agendamento();
      BeanUtils.copyProperties(agendamentoDto, agendamento);

      agendamento.setStatusColeta(StatusColeta.AGENDADO);
      Agendamento agendamentoCriado = agendamentoRespository.save(agendamento);
      return new AgendamentoExibicaoDto(agendamentoCriado);
  }
  public Agendamento editarAgendamento(Long id, AgendamentoDto agendamentoDto) {
    Optional<Agendamento> agendamento = agendamentoRespository.findById(id);
    if (agendamento.isPresent()){

      BeanUtils.copyProperties(agendamentoDto, agendamento);

      Agendamento agendamentoAtualizado = agendamentoRespository.save(agendamento.get());
    return agendamentoAtualizado;
    } else {
      throw new AgendamentoNotFoundException(String.format("Agendamento não encontrado com o id: %s"));
    }
  }

  public void deletarAgendamento (Long id){
    Optional<Agendamento> agendamentoData = agendamentoRespository.findById(id);
    if (agendamentoData.isPresent()){
      agendamentoRespository.delete(agendamentoData.get());
    } else {
      throw new AgendamentoNotFoundException(String.format("Agendamento não encontrado com o id: %s"));
    }
  }
}
