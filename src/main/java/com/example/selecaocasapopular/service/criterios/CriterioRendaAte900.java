package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;

import java.math.BigDecimal;

public class CriterioRendaAte900 implements ICriterioPontuacao {
    @Override
    public int calcularPontuacao(Pessoa pessoa) {
        BigDecimal renda = pessoa.getRendaTotalFamilia();
        if (renda != null && renda.compareTo(BigDecimal.valueOf(900)) <= 0) {
            return 5;
        }
        return 0;
    }
}
