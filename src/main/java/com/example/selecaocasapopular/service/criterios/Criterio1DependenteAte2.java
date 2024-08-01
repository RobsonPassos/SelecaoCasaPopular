package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;

public class Criterio1DependenteAte2  implements ICriterioPontuacao {
    @Override
    public int calcularPontuacao(Pessoa pessoa) {
        int dependentes = pessoa.getDependentesMenoresIdade();
        if (dependentes >= 1 && dependentes <= 2) {
            return 2;
        }
        return 0;
    }
}

