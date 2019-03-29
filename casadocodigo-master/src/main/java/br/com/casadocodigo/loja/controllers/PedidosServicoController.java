package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
@RequestMapping(value="/pedidos", method=RequestMethod.GET)
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping
	public ModelAndView listar() {
		String uri = "https://book-payment.herokuapp.com/orders";
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);
		
		List<Pedido> pedidos = Arrays.asList(restTemplate.getForObject(uri, Pedido[].class));
				
		ModelAndView modelAndView = new ModelAndView("pedidos/pedidos");
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}
}
