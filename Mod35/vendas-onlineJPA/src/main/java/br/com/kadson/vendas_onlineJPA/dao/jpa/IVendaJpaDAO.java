package br.com.kadson.vendas_onlineJPA.dao.jpa;

import br.com.kadson.vendas_onlineJPA.Exceptions.DAOException;
import br.com.kadson.vendas_onlineJPA.Exceptions.TipoChaveNaoEncontradaException;
import br.com.kadson.vendas_onlineJPA.dao.generic.jpa.IGenericJpaDAO;
import br.com.kadson.vendas_onlineJPA.domain.jpa.VendaJpa;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa, Long> {

    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public VendaJpa consultarComCollection(Long id);
}
