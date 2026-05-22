CREATE SEQUENCE IF NOT EXISTS sequence_meme START WITH 1 INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS meme (
    id            BIGINT        NOT NULL,
    nome          VARCHAR(255)  NOT NULL,
    descricao     VARCHAR(255)  NOT NULL,
    url_midia     VARCHAR(2048) NOT NULL,
    data_cadastro DATE          NOT NULL,
    categoria_id  BIGINT        NOT NULL,
    usuario_id    BIGINT        NOT NULL,
    CONSTRAINT pk_meme PRIMARY KEY (id)
);
