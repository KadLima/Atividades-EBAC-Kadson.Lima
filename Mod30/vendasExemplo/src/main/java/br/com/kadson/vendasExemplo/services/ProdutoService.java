package br.com.kadson.vendasExemplo.services;

import br.com.kadson.vendasExemplo.dao.IProdutoDAO;
import br.com.kadson.vendasExemplo.domain.Produto;
import br.com.kadson.vendasExemplo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
