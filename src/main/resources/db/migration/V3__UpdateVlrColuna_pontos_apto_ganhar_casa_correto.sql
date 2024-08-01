UPDATE pessoa
SET pontos_apto_ganhar_casa = (
    -- Soma dos pontos de todos os critérios atendidos
    COALESCE(
                (CASE
                     WHEN dependentes_menores_idade BETWEEN 1 AND 2 THEN 2
                     ELSE 0
                    END) +
                (CASE
                     WHEN dependentes_menores_idade >= 3 THEN 3
                     ELSE 0
                    END) +
                (CASE
                     WHEN renda_total_familia <= 900 THEN 5
                     ELSE 0
                    END) +
                (CASE
                     WHEN renda_total_familia > 900 AND renda_total_familia <= 1500 THEN 3
                     ELSE 0
                    END),
                0
    )
    );
