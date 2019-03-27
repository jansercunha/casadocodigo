package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Produto;

@Controller
@RequestMapping(value="/pedidos", method=RequestMethod.GET)
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping
	public ModelAndView listar() {
		String uri = "https://book-payment.herokuapp.com/orders";
		
		String response = restTemplate.getForObject(uri, String.class);
		List<Pedido> pedidos = response;
		
		ModelAndView modelAndView = new ModelAndView("pedidos/lista");
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}
}
