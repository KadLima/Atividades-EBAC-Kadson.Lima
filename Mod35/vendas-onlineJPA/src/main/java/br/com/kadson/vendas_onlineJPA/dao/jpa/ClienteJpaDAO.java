package br.com.kadson.vendas_onlineJPA.dao.jpa;

import br.com.kadson.vendas_onlineJPA.dao.generic.jpa.GenericJpaDAO;
import br.com.kadson.vendas_onlineJPA.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }

}
