package br.com.fiap.coletaLixo.repository;


import br.com.fiap.coletaLixo.model.Coleta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ColetaRespository extends JpaRepository<Coleta,Long>{
  public Coleta findById(Number id);
}
