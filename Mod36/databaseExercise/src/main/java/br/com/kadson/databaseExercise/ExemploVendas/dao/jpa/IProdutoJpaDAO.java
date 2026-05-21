package br.com.kadson.databaseExercise.ExemploVendas.dao.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ProdutoJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.MaisDeUmRegistroException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TableException;

public interface IProdutoJpaDAO extends IClienteJpaDAO<ProdutoJpa> {

    /**
     * Consulta produto pelo código único
     * @param codigo Código do produto
     * @return Produto encontrado ou null se não existir
     * @throws MaisDeUmRegistroException Se mais de um produto com o mesmo código for encontrado
     * @throws TableException Erro na consulta ao banco
     */
    ProdutoJpa consultarPorCodigo(String codigo) throws MaisDeUmRegistroException, TableException;
}