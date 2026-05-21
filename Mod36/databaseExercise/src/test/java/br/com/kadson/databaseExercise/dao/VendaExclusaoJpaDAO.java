package br.com.kadson.databaseExercise.dao;

import br.com.kadson.databaseExercise.ExemploVendas.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.IVendaJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.VendaJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.DAOException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

    public VendaExclusaoJpaDAO() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

}
