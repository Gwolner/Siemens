package br.com.desafio.siemens.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.siemens.model.classes.Cidade;

public class RepositorioCidade implements Repositorio<Cidade, String>{

	// O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	RepositorioCidade() {}
	
	@Override
	public void inserir(Cidade cidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into cidade (nome, estado) values (?,?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, cidade.getNome());
		pstm.setString(2, cidade.getEstado());

		pstm.execute();
	}

	@Override
	public void alterar(Cidade cidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update cidade set tipo=?, descricao=?, preconormal=?, precocompleta=? where nome=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, cidade.getNome());
		pstm.setString(2, cidade.getEstado());
		
		pstm.setString(5, cidade.getNome());

		pstm.execute();
	}


	// Ler pelo nome da cidade
	public Cidade lerPorCidade(String nomeCidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from cidade where nome = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, nomeCidade);

		ResultSet result = pstm.executeQuery();

		Cidade tCidade = null;

		if (result.next()) {

			tCidade = new Cidade();
			
			tCidade.setNome(nomeCidade);
			tCidade.setEstado(result.getString("estado"));			
		}

		return tCidade;
	}
	
	// Ler pelo estado
	public Cidade lerPorEstado(String nomeEstado) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from cidade where estado = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, nomeEstado);

		ResultSet result = pstm.executeQuery();

		Cidade tCidade = null;

		if (result.next()) {

			tCidade = new Cidade();
			
			tCidade.setNome(result.getString("nome"));
			tCidade.setEstado(nomeEstado);						
		}

		return tCidade;
	}

	@Override
	public void deletar(String nomeCidade) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from cidade where cidade = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, nomeCidade);

		pstm.execute();

	}

	@Override
	public List<Cidade> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tipocarro";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Cidade> tipos = new ArrayList<Cidade>();

		while (result.next()) {

			Cidade tCidade = new Cidade();
			
			tCidade.setNome(result.getString("nome"));
			tCidade.setEstado(result.getString("estado"));			

			tipos.add(tCidade);
		}

		return tipos;
	}
	
}
