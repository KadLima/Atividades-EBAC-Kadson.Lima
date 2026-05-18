package br.com.kadson.vendasExemplo.services;

import br.com.kadson.vendasExemplo.domain.Cliente;
import br.com.kadson.vendasExemplo.exceptions.DAOException;
import br.com.kadson.vendasExemplo.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
