package br.com.carc2ccadastro.repository;

import br.com.carc2ccadastro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findUsuarioByLogin(String login);

}
