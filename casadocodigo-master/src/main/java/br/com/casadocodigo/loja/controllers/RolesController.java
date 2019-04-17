package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RoleDAO dao;
	
	@Autowired 
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/detalhe", method=RequestMethod.POST)
	public ModelAndView detalhe(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
	    ModelAndView modelAndView = new ModelAndView("/roles/detalhe");
	    
	    modelAndView.addObject("listaRoles", dao.listar());
	    modelAndView.addObject("usuario", usuarioDAO.loadUserByUsername(usuario.getEmail()));
	    
	    return modelAndView;
	}
	
	@RequestMapping(value="/alterarPermissoes", method=RequestMethod.POST)
	public ModelAndView alterarPermissoes(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return detalhe(usuario);
		}
		
		List<Role> roles = usuario.getRoles();
		
		usuario = usuarioDAO.loadUserByUsername(usuario.getEmail());
		usuario.setRoles(roles);
		
		usuarioDAO.update(usuario);
		
		redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
	}
}
