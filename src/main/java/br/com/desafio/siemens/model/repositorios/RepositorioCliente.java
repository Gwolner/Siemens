package br.com.desafio.siemens.model.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.siemens.model.classes.Cliente;

public class RepositorioCliente {

	private static RepositorioCliente myself = null;
    
    private List<Cliente> clientes = null;
    
    private RepositorioCliente(){
        this.clientes = new ArrayList<>();
    }
    
    public static RepositorioCliente getCurrentInstance(){
        if(myself == null)
            myself = new RepositorioCliente();
        
        return myself;
    }
    
    public void inserir(Cliente cliente){
        this.clientes.add(cliente);
    }
    
    public void alterar(Cliente cliente){
        for(Cliente c: this.clientes){
            if(c.getNomeCompleto() == cliente.getNomeCompleto()){
                c.setNomeCompleto(cliente.getNomeCompleto());
                c.setSexo(cliente.getSexo());
                c.setDataNascimento(cliente.getDataNascimento());
                c.setIdade(cliente.getIdade());
                c.setCidade(cliente.getCidade());
               
            }
        }
    }
    
    public Cliente lerPorNome(String nomeCompleto){
        for(Cliente c: this.clientes){
            if(c.getNomeCompleto() == nomeCompleto){
                return c;
            }
        }
        return null;
    }
    
    public void excluir(Cliente cliente){
        this.clientes.remove(cliente);
    }
    
    public List<Cliente> lerTudo(){
        return this.clientes;
    }
}
