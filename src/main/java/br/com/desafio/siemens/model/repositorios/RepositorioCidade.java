package br.com.desafio.siemens.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.siemens.model.classes.Cidade;

public class RepositorioCidade implements Repositorio<Cidade, Integer>{

	// O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	RepositorioCidade() {}
	
	@Override
	public void inserir(Cidade cidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into tb_cidade (nome, estado) values (?,?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, cidade.getNome());
		pstm.setString(2, cidade.getEstado());

		pstm.execute();
	}

	@Override
	public void alterar(Cidade cidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update tb_cidade set nome=?, estado=? where id_cidade=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, cidade.getNome());
		pstm.setString(2, cidade.getEstado());
		
		pstm.setInt(3, cidade.getIdCidade());

		pstm.execute();
	}


	@Override
	public Cidade lerId(Integer idCidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tb_cidade where id_cidade=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, idCidade);

		ResultSet result = pstm.executeQuery();

		Cidade cidade = null;

		if (result.next()) {

			cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));			
		}

		return cidade;
	}
	
	
	public List<Cidade> lerNome(String nomeCidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tb_cidade where nome=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, nomeCidade);
		
		ResultSet result = pstm.executeQuery();

		List<Cidade> cidades = new ArrayList<Cidade>();

		while (result.next()) {

			Cidade cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));			

			cidades.add(cidade);
		}

		return cidades;
	}
	
	public List<Cidade> lerEstado(String estado) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tb_cidade where estado=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, estado);
		
		ResultSet result = pstm.executeQuery();

		List<Cidade> cidades = new ArrayList<Cidade>();

		while (result.next()) {

			Cidade cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));			

			cidades.add(cidade);
		}

		return cidades;
	}

	@Override
	public void deletar(Integer idCidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from tb_cidade where id_cidade=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, idCidade);

		pstm.execute();
	}


	@Override
	public List<Cidade> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tb_cidade";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Cidade> cidades = new ArrayList<Cidade>();

		while (result.next()) {

			Cidade cidade = new Cidade();
			
			cidade.setIdCidade(result.getInt("id_cidade"));
			cidade.setNome(result.getString("nome"));
			cidade.setEstado(result.getString("estado"));			

			cidades.add(cidade);
		}

		return cidades;
	}
	
}
