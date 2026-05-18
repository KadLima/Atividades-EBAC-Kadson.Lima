package br.com.kadson.vendasExemplo.services.generic;

import br.com.kadson.vendasExemplo.dao.Persistente;
import br.com.kadson.vendasExemplo.exceptions.DAOException;
import br.com.kadson.vendasExemplo.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {


    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(E valor) throws DAOException;

    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E valor) throws DAOException;

    public Collection<T> buscarTodos() throws DAOException;

}
