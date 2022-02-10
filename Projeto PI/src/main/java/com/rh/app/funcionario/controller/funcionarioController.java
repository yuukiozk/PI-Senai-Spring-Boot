package com.rh.app.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rh.app.funcionario.models.Funcionario;
import com.rh.app.funcionario.repository.FuncionarioRepository;

@Controller
public class funcionarioController {

	@Autowired
	private FuncionarioRepository fr;

	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public String abrirfuncionario() {
		return "funcionario/funcionario";
	}

	@RequestMapping(value = "/funcionario", method = RequestMethod.POST)
	public String gravarfuncionario(Funcionario funcionario) {
		fr.save(funcionario);
		return "redirect:/funcionario";
	}

}
