/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cadastrocliente.dao;

import com.mycompany.cadastrocliente.Domain.Cliente;
import java.util.Collection;

/**
 *
 * @author kadso
 */
public interface IClienteDAO {
    public Boolean cadastrar(Cliente cliente);
    
    public void excluir(String cpf);
    
    public Boolean alterar (Cliente cliente);
    
    public Cliente consultar(String cpf);
    
    public Collection<Cliente> buscarTodos();
    
}
