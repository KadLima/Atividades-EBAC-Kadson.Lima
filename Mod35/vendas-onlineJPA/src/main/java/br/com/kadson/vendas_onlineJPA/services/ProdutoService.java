package br.com.kadson.vendas_onlineJPA.services;

import br.com.kadson.vendas_onlineJPA.dao.IProdutoDAO;
import br.com.kadson.vendas_onlineJPA.domain.Produto;
import br.com.kadson.vendas_onlineJPA.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
