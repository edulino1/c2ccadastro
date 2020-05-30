package br.com.carc2ccadastro.service;

import br.com.carc2ccadastro.domain.Usuario;
import br.com.carc2ccadastro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository){
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario findUsuarioByLogin(String login){
		return usuarioRepository.findUsuarioByLogin(login);
	}
	
	public Usuario salvarUsuario(Usuario usuario){
		return usuarioRepository.save(usuario);
	}


}
