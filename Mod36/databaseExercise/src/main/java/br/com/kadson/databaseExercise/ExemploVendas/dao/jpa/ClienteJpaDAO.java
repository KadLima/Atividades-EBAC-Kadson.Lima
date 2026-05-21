package br.com.kadson.databaseExercise.ExemploVendas.dao.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }

}
