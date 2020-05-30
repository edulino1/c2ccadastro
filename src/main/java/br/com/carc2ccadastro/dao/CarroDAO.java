package br.com.carc2ccadastro.dao;

import br.com.carc2ccadastro.domain.Carro;

import java.util.List;

public interface CarroDAO {
	List<Carro> findCarroByUsuarioId(Long usuarioId);
}
