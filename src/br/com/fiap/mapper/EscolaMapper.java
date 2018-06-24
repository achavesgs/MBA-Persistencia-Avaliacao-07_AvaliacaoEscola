package br.com.fiap.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entity.Escola;

public class EscolaMapper implements RowMapper<Escola>{//mapeia o objeto todo

	@Override
	public Escola mapRow(ResultSet rs, int arg1) throws SQLException {
		Escola escola = new Escola();
		
		escola.setId(rs.getInt("ID"));
		escola.setNome(rs.getString("NOME"));
		escola.setEndereco(rs.getString("ENDERECO"));
		escola.setDataFundacao(rs.getDate("DATA_FUNDACAO"));
		
		return escola;
	}

}
