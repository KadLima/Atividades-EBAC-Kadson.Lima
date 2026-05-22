CREATE SEQUENCE IF NOT EXISTS sequence_usuario START WITH 1 INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS usuario (
    id          BIGINT       NOT NULL,
    nome        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    data_cadastro DATE       NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);
