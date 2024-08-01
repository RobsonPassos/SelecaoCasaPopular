package com.example.selecaocasapopular.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private int dependentesMenoresIdade;
    private int qntPessoasFamilia;
    private BigDecimal rendaTotalFamilia;
    private boolean temCasaPropria;
    private int pontosAptoGanharCasa;
    private boolean contempladoCasa;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}