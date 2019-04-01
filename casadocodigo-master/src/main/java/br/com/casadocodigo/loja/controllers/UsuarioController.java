package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public ModelAndView form(Usuario usuario) {
		
		return null;
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = dao.listar();
		
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
	
//	@RequestMapping("/detalhe/{id}")
//	public ModelAndView detalhe(@PathVariable("id") Integer id){
//		
//		return null;
//	}
}
