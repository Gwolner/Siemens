package br.com.desafio.siemens.model.repositorios;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio <Classe, Id>{
	
	public void inserir(Classe classe) throws SQLException;
	public void alterar(Classe classe) throws SQLException;
	public Classe lerId(Id id) throws SQLException;
	public void deletar(Id id) throws SQLException;
	public List<Classe> lerTudo() throws SQLException;
}
