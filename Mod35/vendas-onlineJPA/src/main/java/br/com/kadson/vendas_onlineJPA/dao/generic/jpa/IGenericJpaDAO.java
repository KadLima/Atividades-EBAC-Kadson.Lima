package br.com.kadson.vendas_onlineJPA.dao.generic.jpa;

import br.com.kadson.vendas_onlineJPA.Exceptions.DAOException;
import br.com.kadson.vendas_onlineJPA.Exceptions.MaisDeUmRegistroException;
import br.com.kadson.vendas_onlineJPA.Exceptions.TableException;
import br.com.kadson.vendas_onlineJPA.Exceptions.TipoChaveNaoEncontradaException;
import br.com.kadson.vendas_onlineJPA.dao.Persistente;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericJpaDAO<T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(T entity) throws DAOException;

    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> buscarTodos() throws DAOException;
}