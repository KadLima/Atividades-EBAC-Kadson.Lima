package br.com.kadson.databaseExercise.ExemploVendas.dao.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.generic.jpa.IGenericJapDAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.VendaJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.DAOException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJapDAO<VendaJpa, Long> {

    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public VendaJpa consultarComCollection(Long id);
}
