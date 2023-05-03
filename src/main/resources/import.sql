INSERT INTO locador(nome, celular) VALUES ('Maria', '11912345678');
INSERT INTO locador(nome, celular) VALUES ('Adeildo', '11987654321');

INSERT INTO locatario(nome, celular) VALUES ('Sara', '11978227770');
INSERT INTO locatario(nome, celular) VALUES ('Eva', '11970219610');

INSERT INTO imovel(locador_id, apelido, endereco) VALUES (2, 'Casa 1', 'Rua Josefina Cinci Ragaini, 57');
INSERT INTO imovel(locador_id, apelido, endereco) VALUES (1, 'Casa 2', 'Rua Ilha do Arvoredo, 41');

INSERT INTO contrato(valor_aluguel, dia_vencimento, dt_contrato, prazo, imovel_id, locatario_id) VALUES (600, 5, '2023-04-05', 1, 1, 1);
INSERT INTO contrato(valor_aluguel, dia_vencimento, dt_contrato, prazo, imovel_id, locatario_id) VALUES (700, 6, '2023-04-06', 1, 2, 2);