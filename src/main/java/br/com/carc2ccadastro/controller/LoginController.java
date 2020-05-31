package br.com.carc2ccadastro.controller;

import br.com.carc2ccadastro.domain.Usuario;
import br.com.carc2ccadastro.security.LoginSecurity;
import br.com.carc2ccadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private static final String TELA_LOGIN = "login";
	
	@GetMapping("/login")
	public String getLogin(Model model){
		
		if(LoginSecurity.logado){
			return "index";
		}
		
		return TELA_LOGIN;
	}
	
	@PostMapping("/login")
	public String postLogin(Usuario usuario, Model model){
		
		Usuario usuarioExiste = usuarioService.findUsuarioByLogin(usuario.getLogin());
		
		if(usuarioExiste != null){
			if(usuarioExiste.getPassword().equals(usuario.getPassword())) {
				
				LoginSecurity.logado = true;
				
				LoginSecurity.usuario = usuarioExiste;
				
				return "redirect:/";
			}
		}
		
		model.addAttribute("dadosFeedback", true);
		
		return getLogin(model);
	}
	
	@PostMapping("/cadastrar")
	public String postCadastroUsuario(Model model, Usuario usuario){
		
		Usuario usuarioExiste = usuarioService.findUsuarioByLogin(usuario.getLogin());
		
		if(usuarioExiste != null){
			
			model.addAttribute("usuarioCadastradoFeedback", true);
			
			return getLogin(model);
			
		}
		
		usuarioService.salvarUsuario(usuario);
		
		return postLogin(usuario, model);
	}
	
	
}
