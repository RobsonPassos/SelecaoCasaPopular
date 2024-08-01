package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;

public class Criterio3DependentesOuMais implements ICriterioPontuacao {
    @Override
    public int calcularPontuacao(Pessoa pessoa) {
        if (pessoa.getDependentesMenoresIdade() >= 3) {
            return 3;
        }
        return 0;
    }
}