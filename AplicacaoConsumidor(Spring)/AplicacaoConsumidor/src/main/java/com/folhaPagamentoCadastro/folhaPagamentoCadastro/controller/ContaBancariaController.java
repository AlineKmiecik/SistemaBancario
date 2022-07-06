package com.folhaPagamentoCadastro.folhaPagamentoCadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.MovimentacoesConta;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.service.ContaBancariaService;

@RestController
@RequestMapping(path = "/conta")
public class ContaBancariaController {
	@Autowired
	ContaBancariaService contaBancariaService;
	
	@RequestMapping("/saldo/{agencia}/{conta}")
	@ResponseBody
	public double getSaldo(@PathVariable(value="agencia") String agencia, 
			                   @PathVariable(value="conta") String conta) {
		
		return contaBancariaService.consultarSaldo(agencia, conta);
	}
	
	@RequestMapping("/movimentacoes/{agencia}/{conta}")
	@ResponseBody
	public List<MovimentacoesConta> getMovimentcoes(@PathVariable(value="agencia") String agencia, 
			                   @PathVariable(value="conta") String conta) {
		
		return contaBancariaService.consultarMovimentacoes(agencia, conta);
	}
	
	
}
