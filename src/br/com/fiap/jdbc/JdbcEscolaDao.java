package br.com.fiap.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entity.Escola;
import br.com.fiap.mapper.EscolaMapper;

public class JdbcEscolaDao {
	
	private JdbcTemplate jdbcTemplate;
	
	//propriedade: dataSource
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//método para incluir uma escola
	public void incluirEscola(Escola escola) throws Exception {
		try {
			String sql = "INSERT INTO ESCOLA "
					+ "(NOME,ENDERECO,DATA_FUNDACAO) VALUES (?,?,?)";
			this.jdbcTemplate.update(sql,
					escola.getNome(),
					escola.getEndereco(),
					escola.getDataFundacao());
		} catch (Exception e) {
			throw e;
		}
	}
	
	//método para buscar uma escola por nome
	public Escola buscarEscolaPorNome(String nomeEscola) throws Exception {
		Escola escola = null;
		try {
			String query = "SELECT * FROM ESCOLA WHERE upper(NOME) = upper(?) ";
			escola = this.jdbcTemplate.queryForObject(
					query,
					new String[] {nomeEscola}, new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escola;
	}
	
	//método para buscar uma escola por id
	public Escola buscarEscolaPorId(int idEscola) throws Exception {
		Escola escola = null;
		try {
			String query = "SELECT * FROM ESCOLA WHERE ID = ? ";
			escola = this.jdbcTemplate.queryForObject(
					query,
					new Integer[] {idEscola}, new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escola;
	}
	
	//método para listar todas as escolas
	public List<Escola> listarEscolas() throws Exception {
		List<Escola> escolas = new ArrayList<>();
		try {
			escolas = this.jdbcTemplate.query(
					"SELECT * FROM ESCOLA",
					new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escolas;
	}
	
	

}
