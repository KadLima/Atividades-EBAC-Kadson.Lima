package br.com.kadson.vendas_onlineJPA.dao;

import br.com.kadson.vendas_onlineJPA.Exceptions.DAOException;
import br.com.kadson.vendas_onlineJPA.Exceptions.TipoChaveNaoEncontradaException;
import br.com.kadson.vendas_onlineJPA.dao.generic.IGenericDAO;
import br.com.kadson.vendas_onlineJPA.domain.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
