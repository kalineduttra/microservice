package br.com.fiap.coletaLixo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Agendamento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "agendamento_id")
    private Long id;

    private String endereco;

    private LocalDate data;

    @NotBlank
    private String cliente;

    @NotNull
    @Column(name = "status")
    private StatusColeta statusColeta;

}
