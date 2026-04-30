-- ===========================================
-- DADOS DE TESTE - SISTEMA DE CARROS
-- ===========================================

-- Limpar dados existentes
DELETE FROM carro_acessorio;
DELETE FROM carro;
DELETE FROM acessorio;
DELETE FROM marca;

-- Resets IDs
ALTER TABLE marca ALTER COLUMN id RESTART WITH 1;
ALTER TABLE acessorio ALTER COLUMN id RESTART WITH 1;
ALTER TABLE carro ALTER COLUMN id RESTART WITH 1;

-- ===========================================
-- INSERIR MARCAS
-- ===========================================
INSERT INTO marca (nome, pais_origem, ano_fundacao) VALUES
                                                        ('Toyota', 'Japão', 1937),
                                                        ('Honda', 'Japão', 1948),
                                                        ('Volkswagen', 'Alemanha', 1937),
                                                        ('Ford', 'Estados Unidos', 1903),
                                                        ('Fiat', 'Itália', 1899),
                                                        ('Hyundai', 'Coreia do Sul', 1967);

-- ===========================================
-- INSERIR ACESSÓRIOS
-- ===========================================
INSERT INTO acessorio (nome, descricao, preco) VALUES
                                                   ('Ar Condicionado', 'Sistema de refrigeração e climatização', 2500.00),
                                                   ('Direção Elétrica', 'Direção assistida elétrica', 1800.00),
                                                   ('Vidros Elétricos', 'Vidros com controle elétrico nas portas', 1200.00),
                                                   ('Teto Solar', 'Teto solar elétrico panorâmico', 3500.00),
                                                   ('Sensor de Ré', 'Sensor de estacionamento traseiro', 800.00),
                                                   ('Câmera de Ré', 'Câmera auxiliar para estacionamento', 1500.00),
                                                   ('Banco de Couro', 'Bancos revestidos em couro legítimo', 3000.00),
                                                   ('Rodas de Liga Leve', 'Rodas esportivas de alumínio', 2500.00);

-- ===========================================
-- INSERIR CARROS
-- ===========================================
INSERT INTO carro (modelo, placa, ano, preco, cor, marca_id) VALUES
                                                                 ('Corolla', 'ABC-1234', 2023, 120000.00, 'Prata', 1),
                                                                 ('Civic', 'DEF-5678', 2023, 125000.00, 'Preto', 2),
                                                                 ('Golf', 'GHI-9012', 2022, 110000.00, 'Branco', 3),
                                                                 ('Fusion', 'JKL-3456', 2023, 135000.00, 'Azul', 4),
                                                                 ('Uno', 'MNO-7890', 2022, 45000.00, 'Vermelho', 5),
                                                                 ('HB20', 'PQR-1234', 2023, 75000.00, 'Prata', 6),
                                                                 ('Corolla Cross', 'STU-5678', 2024, 160000.00, 'Preto', 1),
                                                                 ('HR-V', 'VWX-9012', 2023, 145000.00, 'Branco', 2);

-- ===========================================
-- RELACIONAR CARROS COM ACESSÓRIOS
-- ===========================================

-- Toyota Corolla (ID 1) - Acessórios: Ar Condicionado, Direção Elétrica, Vidros Elétricos
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (1, 1), (1, 2), (1, 3);

-- Honda Civic (ID 2) - Acessórios: Ar Condicionado, Câmera de Ré, Banco de Couro
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (2, 1), (2, 6), (2, 7);

-- Volkswagen Golf (ID 3) - Acessórios: Teto Solar, Rodas de Liga Leve
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (3, 4), (3, 8);

-- Ford Fusion (ID 4) - Acessórios: Ar Condicionado, Direção Elétrica, Câmera de Ré, Banco de Couro
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (4, 1), (4, 2), (4, 6), (4, 7);

-- Fiat Uno (ID 5) - Acessórios: Apenas Ar Condicionado
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
    (5, 1);

-- Hyundai HB20 (ID 6) - Acessórios: Ar Condicionado, Direção Elétrica, Sensor de Ré
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (6, 1), (6, 2), (6, 5);

-- Toyota Corolla Cross (ID 7) - Acessórios: Todos os topo de linha
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (7, 1), (7, 2), (7, 3), (7, 4), (7, 6), (7, 7), (7, 8);

-- Honda HR-V (ID 8) - Acessórios: Pacote completo de segurança e conforto
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES
                                                         (8, 1), (8, 2), (8, 5), (8, 6);
