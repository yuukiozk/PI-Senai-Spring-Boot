package com.rh.app.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rh.app.funcionario.repository.FuncionarioRepository;

@Controller
public class indexController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");

		String mensagem = "Olá Seja Bem Vinda(o) !";
		mv.addObject("msg", mensagem);

		return mv;
	}

	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.POST) public
	 * ModelAndView buscarIndex(@RequestParam("buscar") String buscar) {
	 * ModelAndView mv = new ModelAndView("index");
	 * 
	 * String mensagem = "Resultado da Busca !"; mv.addObject("msg", mensagem);
	 * mv.addObject("buscar", buscar);
	 * 
	 * return mv; }
	 */
	
	@Autowired
	FuncionarioRepository fr;
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar) {
		ModelAndView mv = new ModelAndView("index");

		String mensagem = "Resultado da Busca !";		
		
		mv.addObject("msg", mensagem);		
		mv.addObject("funcionarios", fr.findByNomes(buscar) );

		return mv;
	}

}
