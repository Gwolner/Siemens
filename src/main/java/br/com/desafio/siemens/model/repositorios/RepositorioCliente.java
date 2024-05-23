package br.com.desafio.siemens.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.siemens.model.classes.Cidade;
import br.com.desafio.siemens.model.classes.Cliente;

public class RepositorioCliente implements Repositorio<Cliente, Integer>{
	
	// O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	RepositorioCliente() {}

	@Override
	public void inserir(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into tb_cliente (nome_completo, sexo, data_nascimento, idade, id_cidade) values (?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cliente.getNomeCompleto());
		pstm.setString(2, cliente.getSexo());
		pstm.setString(3, cliente.getDataNascimento());
		pstm.setInt(4, cliente.getIdade());		
		pstm.setInt(5, cliente.getCidade().getIdCidade());
		
		pstm.execute();
		
	}

	@Override
	public void alterar(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update tb_cliente set nome_completo=?, sexo=?, data_nascimento=?, idade=?, id_cidade=? where id_cliente=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cliente.getNomeCompleto());
		pstm.setString(2, cliente.getSexo());
		pstm.setString(3, cliente.getDataNascimento());
		pstm.setInt(4, cliente.getIdade());	
		pstm.setInt(5, cliente.getCidade().getIdCidade());	
		
		pstm.setInt(6, cliente.getIdCliente());
		
		pstm.execute();
	}

	@Override
	public Cliente lerId(Integer idCliente) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from tb_cliente as cli "
				+ "join tb_cidade as cid "
				+ "on (cli.id_cidade = cid.id_cidade) "
				+ "where cli.id_cliente = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, idCliente);
		
		ResultSet result = pstm.executeQuery();
		
		Cliente cliente = null;
		
		if(result.next()) {
			
			cliente = new Cliente();
			
			cliente.setIdCliente(result.getInt("id_cliente"));
			cliente.setNomeCompleto(result.getString("nome_completo"));
			cliente.setSexo(result.getString("sexo"));
			cliente.setDataNascimento(result.getString("data_nascimento")); 
			cliente.setIdade(result.getInt("idade")); 
			
			Cidade cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));
			
			cliente.setCidade(cidade);
		}
		
		return cliente;
	}
	
	public List<Cliente> lerNome(String nomeCompleto) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from tb_cliente as cli "
				+ "join tb_cidade as cid "
				+ "on (cli.id_cidade = cid.id_cidade) "
				+ "where cli.nome_completo=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, nomeCompleto);
		
		ResultSet result = pstm.executeQuery();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		while(result.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente = new Cliente();
			
			cliente.setIdCliente(result.getInt("id_cliente"));
			cliente.setNomeCompleto(result.getString("nome_completo"));
			cliente.setSexo(result.getString("sexo"));
			cliente.setDataNascimento(result.getString("data_nascimento")); 
			cliente.setIdade(result.getInt("idade"));
 
			
			Cidade cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));
			
			cliente.setCidade(cidade);
			
			clientes.add(cliente);
		}
		
		return clientes;
	}

	@Override
	public void deletar(Integer idCliente) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from tb_cliente where id_cliente=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, idCliente);
		
		pstm.execute();
	}

	@Override
	public List<Cliente> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from tb_cliente as cli "
				+ "join tb_cidade as cid "
				+ "on (cli.id_cidade = cid.id_cidade) ";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		while(result.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente = new Cliente();
			
			cliente.setIdCliente(result.getInt("id_cliente"));
			cliente.setNomeCompleto(result.getString("nome_completo"));
			cliente.setSexo(result.getString("sexo"));
			cliente.setDataNascimento(result.getString("data_nascimento")); 
			cliente.setIdade(result.getInt("idade"));
 
			
			Cidade cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));
			
			cliente.setCidade(cidade);
			
			clientes.add(cliente);
		}
		
		return clientes;
	}

}
