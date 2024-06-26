package br.com.fiap.coletaLixo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_coleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coleta {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    @Column(name = "coleta_id")
    private Long id;

    @Column(name = "name_item")
    private String nameItem;

    @Column(name = "qnt_item")
    private Number qntItem;

    private String material;
}
