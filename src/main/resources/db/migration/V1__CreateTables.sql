-- V1__CreateTables.sql
CREATE TABLE endereco (
                          id SERIAL PRIMARY KEY,
                          estado VARCHAR(50),
                          cidade VARCHAR(50),
                          logradouro VARCHAR(100),
                          numero VARCHAR(10)
);

CREATE TABLE pessoa (
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(100),
                        cpf VARCHAR(11) UNIQUE,
                        dependentes_menores_idade INTEGER,
                        qnt_pessoas_familia INTEGER,
                        renda_total_familia DECIMAL,
                        tem_casa_propria BOOLEAN,
                        pontos_apto_ganhar_casa INTEGER,
                        contemplado_casa BOOLEAN,
                        endereco_id INTEGER,
                        FOREIGN KEY (endereco_id) REFERENCES endereco (id)
);
