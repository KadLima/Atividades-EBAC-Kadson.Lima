package br.com.kadson.vendas_onlineJPA.services;

import br.com.kadson.vendas_onlineJPA.Exceptions.DAOException;
import br.com.kadson.vendas_onlineJPA.domain.Cliente;
import br.com.kadson.vendas_onlineJPA.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
