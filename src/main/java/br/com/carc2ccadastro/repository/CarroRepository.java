package br.com.carc2ccadastro.repository;

import br.com.carc2ccadastro.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	
	@Query(value = "SELECT * FROM CARRO WHERE STATUS_CARRO IS FALSE", nativeQuery = true)
	List<Carro> findAll();
}