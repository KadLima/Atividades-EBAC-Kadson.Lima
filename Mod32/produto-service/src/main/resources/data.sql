
-- Limpar dados existentes
DELETE FROM produto;

-- Reset ID
ALTER TABLE produto ALTER COLUMN id RESTART WITH 1;

-- ===========================================
-- INSERIR PRODUTOS
-- ===========================================
INSERT INTO produto (nome, descricao, preco, quantidade_estoque, data_cadastro, ativo, categoria) VALUES
                                                                                                      ('Camiseta Básica', 'Camiseta 100% algodão, confortável e durável', 49.90, 100, CURRENT_TIMESTAMP, true, 'Vestuário'),
                                                                                                      ('Calça Jeans', 'Calça jeans azul clássica, modelo reto', 149.90, 50, CURRENT_TIMESTAMP, true, 'Vestuário'),
                                                                                                      ('Tênis Esportivo', 'Tênis para corrida com amortecimento', 299.90, 30, CURRENT_TIMESTAMP, true, 'Calçados'),
                                                                                                      ('Mochila', 'Mochila para notebook de 15 polegadas', 199.90, 25, CURRENT_TIMESTAMP, true, 'Acessórios'),
                                                                                                      ('Relógio Digital', 'Relógio com cronômetro e alarme', 89.90, 60, CURRENT_TIMESTAMP, true, 'Acessórios'),
                                                                                                      ('Óculos de Sol', 'Óculos com proteção UV 400', 79.90, 45, CURRENT_TIMESTAMP, true, 'Acessórios'),
                                                                                                      ('Garrafa Térmica', 'Garrafa de aço inoxidável 500ml', 59.90, 80, CURRENT_TIMESTAMP, true, 'Casa e Cozinha'),
                                                                                                      ('Fone de Ouvido', 'Fone bluetooth com cancelamento de ruído', 159.90, 40, CURRENT_TIMESTAMP, true, 'Eletrônicos'),
                                                                                                      ('Carregador Portátil', 'Power bank 10000mAh', 99.90, 55, CURRENT_TIMESTAMP, true, 'Eletrônicos'),
                                                                                                      ('Mouse Gamer', 'Mouse com 7 botões programáveis', 129.90, 35, CURRENT_TIMESTAMP, true, 'Eletrônicos'),
                                                                                                      ('Teclado Mecânico', 'Teclado RGB com switches mecânicos', 249.90, 20, CURRENT_TIMESTAMP, true, 'Eletrônicos'),
                                                                                                      ('Monitor 24"', 'Monitor LED Full HD 24 polegadas', 899.90, 15, CURRENT_TIMESTAMP, true, 'Eletrônicos'),
                                                                                                      ('Cadeira Gamer', 'Cadeira ergonômica para jogos', 1299.90, 10, CURRENT_TIMESTAMP, true, 'Móveis'),
                                                                                                      ('Smartphone', 'Smartphone Android 128GB', 1999.90, 8, CURRENT_TIMESTAMP, true, 'Eletrônicos'),
                                                                                                      ('Livro Spring Boot', 'Livro sobre Spring Boot e microservices', 89.90, 12, CURRENT_TIMESTAMP, true, 'Livros'),
                                                                                                      ('Caneca Personalizada', 'Caneca térmica com logo', 29.90, 200, CURRENT_TIMESTAMP, true, 'Casa e Cozinha'),
                                                                                                      ('Boné', 'Boné ajustável unissex', 39.90, 150, CURRENT_TIMESTAMP, true, 'Vestuário'),
                                                                                                      ('Fone de Ouvido Simples', 'Fone de ouvido com fio', 29.90, 0, CURRENT_TIMESTAMP, false, 'Eletrônicos');
