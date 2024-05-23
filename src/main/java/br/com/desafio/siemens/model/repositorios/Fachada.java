package br.com.desafio.siemens.model.repositorios;

import java.sql.SQLException;
import java.util.List;

import br.com.desafio.siemens.model.classes.Cidade;
import br.com.desafio.siemens.model.classes.Cliente;

public class Fachada {
	
	private static Fachada myself = null;
	
	private RepositorioCidade rCidade = null;
	private RepositorioCliente rCliente = null;
	
	private Fachada() {
		this.rCidade = new RepositorioCidade();
		this.rCliente= new RepositorioCliente();
	}
	
	public static Fachada getCurrentInstance() {		
		if(myself == null)
			myself = new Fachada();		
		return myself;		
	}
	
	
	/** ##################################
	 *  ######### FACHADA CIDADE #########
	 *  ##################################
	 */
	
	/**
	 * 
	 * @param cidade
	 * @throws SQLException
	 */
	public void inserirCidade(Cidade cidade) throws SQLException {
		this.rCidade.inserir(cidade);
	}
	
	
	/**
	 * 
	 * @param cidade
	 * @throws SQLException
	 */
	public void alterarCidade(Cidade cidade) throws SQLException {
		this.rCidade.alterar(cidade);
	}
	
	/**
	 * 
	 * @param idCidade
	 * @return 
	 * @throws SQLException
	 */
	public Cidade lerCidadePorId(Integer idCidade) throws SQLException {
		return this.rCidade.lerId(idCidade);
	}	
	
	
	public List<Cidade> lerCidadePorNome(String nome) throws SQLException {
		return this.rCidade.lerNome(nome);
	}
	
	public List<Cidade> lerCidadePorEstado(String estado) throws SQLException {
		return this.rCidade.lerEstado(estado);
	}
	
	/**
	 * 
	 * @param idCidade
	 * @throws SQLException
	 */
	public void deletarCidade(Integer idCidade) throws SQLException {
		this.rCidade.deletar(idCidade);
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Cidade> ListarCidades() throws SQLException{
		return this.rCidade.lerTudo();
	}
	
	
	/** ##################################
	 *  ######## FACHADA CLIENTE #########
	 *  ##################################
	 */
	
	/**
	 * 
	 * @param cidade
	 * @throws SQLException
	 */
	public void inserirCliente(Cliente cliente) throws SQLException {
		this.rCliente.inserir(cliente);
	}
	
	
	/**
	 * 
	 * @param cidade
	 * @throws SQLException
	 */
	public void alterarCliente(Cliente cliente) throws SQLException {
		this.rCliente.alterar(cliente);
	}
	
	/**
	 * 
	 * @param idCidade
	 * @return 
	 * @throws SQLException
	 */
	public Cliente lerClientePorId(Integer idCliente) throws SQLException {
		return this.rCliente.lerId(idCliente);
	}	
	
	/**
	 * 
	 * @param nomeCompleto
	 * @return
	 * @throws SQLException
	 */
	public List<Cliente> lerClientePorNome(String nomeCompleto) throws SQLException {
		return this.rCliente.lerNome(nomeCompleto);
	}	
	
	/**
	 * 
	 * @param idCidade
	 * @throws SQLException
	 */
	public void deletarCliente(Integer idCidade) throws SQLException {
		this.rCliente.deletar(idCidade);
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Cliente> ListarClientes() throws SQLException{
		return this.rCliente.lerTudo();
	}
}
