package br.com.carc2ccadastro.dao.impl;

import br.com.carc2ccadastro.dao.CarroDAO;
import br.com.carc2ccadastro.domain.Carro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarroDAOImpl implements CarroDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public CarroDAOImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Carro> findCarroByUsuarioId(Long usuarioId) {
		
		String sql = "SELECT ID, COR, DESCRICAO, MARCA, MODELO, PLACA, TIPO, USUARIO_ID as usuarioId, STATUS_CARRO as statusCarro FROM CARRO where USUARIO_ID = ?";
	
		return this.jdbcTemplate.query(sql, new Object[] {usuarioId}, new BeanPropertyRowMapper<>(Carro.class));
	}
}
