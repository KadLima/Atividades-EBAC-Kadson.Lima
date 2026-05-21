package br.com.kadson.databaseExercise.ExemploVendas.dao.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ProdutoJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.MaisDeUmRegistroException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TableException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }

    @Override
    public ProdutoJpa consultarPorCodigo(String codigo) throws MaisDeUmRegistroException, TableException {
        try {
            openConnection();
            TypedQuery<ProdutoJpa> query = this.entityManager.createQuery(
                    "SELECT p FROM ProdutoJpa p WHERE p.codigo = :codigo", ProdutoJpa.class);
            query.setParameter("codigo", codigo);
            ProdutoJpa result = query.getSingleResult();
            entityManager.getTransaction().commit();
            closeConnection();
            return result;
        } catch (NoResultException e) {
            closeConnection();
            return null;
        } catch (Exception e) {
            throw new TableException("Erro ao consultar produto por código", e);
        }
    }
}
