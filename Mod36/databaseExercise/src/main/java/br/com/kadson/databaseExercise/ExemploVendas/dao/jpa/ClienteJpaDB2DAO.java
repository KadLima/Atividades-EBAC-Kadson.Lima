package br.com.kadson.databaseExercise.ExemploVendas.dao.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDB2DAO() {
        super(ClienteJpa.class);
    }

}
