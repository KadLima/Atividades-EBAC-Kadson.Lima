/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrocliente.dao;

import com.mycompany.cadastrocliente.Domain.Cliente;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author kadso
 */
public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }
    
    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }




    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }

    @Override
    public void excluir(String cpf) {
         Cliente clienteEncontrado = null;
        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            this.set.remove(clienteEncontrado);
        }
    }

    @Override
    public Cliente consultar(String cpf) {
        for(Cliente clienteCadastrado : this.set){
            if (clienteCadastrado.getCpf().equals(cpf)){
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public Boolean alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                if(clienteCadastrado.equals(cliente)){
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
