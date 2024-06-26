package br.com.fiap.coletaLixo.repository;



import br.com.fiap.coletaLixo.dto.AgendamentoDto;
import br.com.fiap.coletaLixo.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AgendamentoRespository extends JpaRepository<Agendamento,Long>{

}
