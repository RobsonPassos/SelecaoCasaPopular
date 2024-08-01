package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;

import java.math.BigDecimal;

public class CriterioRendaMaiorQue900Ate1500 implements ICriterioPontuacao {
    @Override
    public int calcularPontuacao(Pessoa pessoa) {
        BigDecimal renda = pessoa.getRendaTotalFamilia();
        if (renda != null && renda.compareTo(BigDecimal.valueOf(900)) >= 0 && renda.compareTo(BigDecimal.valueOf(1500)) <= 0) {
            return 3;
        }
        return 0;
    }
}