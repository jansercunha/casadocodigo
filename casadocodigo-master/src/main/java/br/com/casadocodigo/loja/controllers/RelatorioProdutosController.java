package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
@RequestMapping(value="/relatorio-produtos", method=RequestMethod.GET)
@ResponseBody
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;

	@RequestMapping()
	public Map<String, Object> listarTodosProdutos(@RequestParam(value="data", required=false) String data) {
		List<Produto> produtos;
		
		if (data == null) produtos = produtoDao.listar();
		else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(simpleDateFormat.parse(data));
			} catch (ParseException e) {
				throw new RuntimeException("Erro na data use: yyyy-MM-dd");
			}
			
			produtos = produtoDao.listarPorDataLancamento(calendar);
		}
		
		Map<String, Object> retorno = new LinkedHashMap<>();
		retorno.put("dataGeracao", Calendar.getInstance());
		retorno.put("quantidade", produtos.size());
		retorno.put("produtos", produtos);
		
		return retorno;
	}
}
