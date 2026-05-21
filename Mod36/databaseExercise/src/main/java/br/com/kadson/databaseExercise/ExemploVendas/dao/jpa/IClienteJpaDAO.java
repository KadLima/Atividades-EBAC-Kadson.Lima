package br.com.kadson.databaseExercise.ExemploVendas.dao.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.generic.jpa.IGenericJapDAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long> {

}
