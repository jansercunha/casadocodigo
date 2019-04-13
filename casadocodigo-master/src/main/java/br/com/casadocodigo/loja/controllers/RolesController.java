package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RoleDAO dao;
	
	@Autowired 
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/detalhe", method=RequestMethod.POST)
	public ModelAndView detalhe(@RequestParam(value="email") String email) {
		email.replaceFirst(",", email)
		
	    ModelAndView modelAndView = new ModelAndView("/roles/detalhe");
	    
	    modelAndView.addObject("roles", dao.listar());
	    
	    Usuario usuario = usuarioDAO.loadUserByUsername(email);
	    modelAndView.addObject("usuario", usuario);
	    
	    return modelAndView;
	}
}
