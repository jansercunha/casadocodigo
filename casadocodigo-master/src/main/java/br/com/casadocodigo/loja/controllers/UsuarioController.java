package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation(dao));
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		return modelAndView;
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = dao.listar();
		
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()) {
			return form(usuario);
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		
		dao.gravar(usuario);
		
		redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
	}
	
	
	@RequestMapping(value="/detalhe", method=RequestMethod.POST)
	public ModelAndView detalhe(@ModelAttribute("usuario") Usuario usuario) {
		
	    ModelAndView modelAndView = new ModelAndView("/usuarios/detalhe");
	    
	    modelAndView.addObject("listaRoles", roleDAO.listar());
	    modelAndView.addObject("usuario", dao.loadUserByUsername(usuario.getEmail()));
	    
	    return modelAndView;
	}
	
	@RequestMapping(value="/alterarPermissoes", method=RequestMethod.POST)
	public ModelAndView alterarPermissoes(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttributes) {
		
		List<Role> roles = usuario.getRoles();
		
		usuario = dao.loadUserByUsername(usuario.getEmail());
		usuario.setRoles(roles);
		
		dao.update(usuario);
		
		redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
	}
}
