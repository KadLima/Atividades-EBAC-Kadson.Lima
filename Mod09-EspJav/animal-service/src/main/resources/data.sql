INSERT
INTO
    animal
    (tipo_animal, nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte)
VALUES
    ('Cachorro','Au au', 4,'Beagle', current_date, 'Mais limpo do quê o esperado','Kadson', 'Pequeno-médio');

INSERT
INTO
    animal
(tipo_animal, nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte)
VALUES
    ( 'Cachorro','Pluto', 7,'Rottweiler', current_date - 10, 'Extremamente agressivo','Guilherme', 'Médio-grande');

INSERT
INTO
    animal
(tipo_animal, nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_adocao)
VALUES
    ('Gato','Lulu', 1,'Não identificada', current_date-5, 'Muito sonolenta','Lima', 'Pequeno', current_date+10);

INSERT INTO animal
(tipo_animal, nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte)
VALUES
    ( 'Gato','Miau', 2,'Siamês', '2024-01-15', 'Assustada','Kadson', 'Pequeno');

INSERT INTO animal
(tipo_animal, nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_adocao)
VALUES
    ('Cachorro','Rex', 3,'Labrador', '2024-03-20', 'Bom estado','Guilherme', 'Grande', '2024-05-10');

INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal)
VALUES
    ('Piu', 1,'Canário', '2024-06-01', 'Saudável','Lima', 'Pequeno', 'Pássaro');

INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal)
VALUES
    ('Tob', 3,'Golden Retrivier', '2025-06-01', 'Pulguento','Lima', 'Grande', 'Cachorro');