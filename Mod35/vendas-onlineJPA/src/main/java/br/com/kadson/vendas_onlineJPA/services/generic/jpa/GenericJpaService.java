package br.com.kadson.vendas_onlineJPA.services.generic.jpa;

import br.com.kadson.vendas_onlineJPA.Exceptions.DAOException;
import br.com.kadson.vendas_onlineJPA.Exceptions.MaisDeUmRegistroException;
import br.com.kadson.vendas_onlineJPA.Exceptions.TableException;
import br.com.kadson.vendas_onlineJPA.Exceptions.TipoChaveNaoEncontradaException;
import br.com.kadson.vendas_onlineJPA.dao.Persistente;
import br.com.kadson.vendas_onlineJPA.dao.generic.jpa.IGenericJpaDAO;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable>
        implements IGenericJpaService<T, E> {

    protected IGenericJpaDAO<T, E> dao;

    public GenericJpaService(IGenericJpaDAO<T, E> dao) {
        this.dao = dao;
    }


    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }

}
