package br.com.kadson.vendasExemplo.dao;

import br.com.kadson.vendasExemplo.dao.generic.IGenericDAO;
import br.com.kadson.vendasExemplo.domain.Venda;
import br.com.kadson.vendasExemplo.exceptions.DAOException;
import br.com.kadson.vendasExemplo.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
