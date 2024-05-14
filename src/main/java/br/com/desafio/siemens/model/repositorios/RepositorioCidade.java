package br.com.desafio.siemens.model.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.siemens.model.classes.Cidade;

public class RepositorioCidade {

	private static RepositorioCidade myself = null;
    
    private List<Cidade> cidades = null;
    
    private RepositorioCidade(){
        this.cidades = new ArrayList<>();
    }
    
    public static RepositorioCidade getCurrentInstance(){
        if(myself == null)
            myself = new RepositorioCidade();
        
        return myself;
    }
    
    public void inserir(Cidade cidade){
        this.cidades.add(cidade);
    }
    
    public void alterar(Cidade cidade){
        for(Cidade c: this.cidades){
            if(c.getNome() == cidade.getNome()){
                c.setNome(cidade.getNome());
                c.setEstado(cidade.getEstado());               
            }
        }
    }
    
    public Cidade lerPorNome(String nomeCidade){
        for(Cidade c: this.cidades){
            if(c.getNome() == nomeCidade){
                return c;
            }
        }
        return null;
    }
    
    public Cidade lerPorEstado(String estado){
        for(Cidade c: this.cidades){
            if(c.getEstado() == estado){
                return c;
            }
        }
        return null;
    }
    
    public void excluir(Cidade cidade){
        this.cidades.remove(cidade);
    }
    
    public List<Cidade> lerTudo(){
        return this.cidades;
    }
}
