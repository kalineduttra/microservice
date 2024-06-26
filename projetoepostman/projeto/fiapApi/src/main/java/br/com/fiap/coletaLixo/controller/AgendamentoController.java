package br.com.fiap.coletaLixo.controller;

import br.com.fiap.coletaLixo.dto.AgendamentoDto;
import br.com.fiap.coletaLixo.model.Agendamento;
import br.com.fiap.coletaLixo.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/agendamentos")
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        try {
            List<Agendamento> agendamentos = agendamentoService.listarAgendamentos();
            if (agendamentos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.ok(agendamentos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/agendamentos")
    public ResponseEntity criarAgendamento (@RequestBody AgendamentoDto agendamento) {
        try{
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.criarAgendamento(agendamento));
        } catch (Exception e) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity editarAgendamento (@PathVariable Long id, @RequestBody AgendamentoDto agendamento) {
        agendamentoService.editarAgendamento(id, agendamento);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);

    }

    @DeleteMapping("/agendamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
      agendamentoService.deletarAgendamento(id);
    }
}
