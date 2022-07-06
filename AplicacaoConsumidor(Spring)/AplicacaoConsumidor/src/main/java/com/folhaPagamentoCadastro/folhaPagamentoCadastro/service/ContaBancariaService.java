package com.folhaPagamentoCadastro.folhaPagamentoCadastro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.ContaBancariaModel;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.MovimentacoesConta;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.repositories.ContaBancariaRepository;

@Service
public class ContaBancariaService {
	ContaBancariaRepository contaRepository = new ContaBancariaRepository();
	
	public void cadastrarConta(ContaBancariaModel conta) {
		contaRepository.cadastrarConta(conta);
	}
	
	public void realizarDeposito(ContaBancariaModel conta) {
		if (conta.getValor() > 0) {
			contaRepository.deposito(conta.getAgencia(), conta.getConta(), conta.getValor());
		}else {
			System.out.println("DEPOSITOS DEVEM SER MAIOR QUE R$ 0.0");
		}
		
	}
	
	public void realizarSaque(ContaBancariaModel conta) {
		if (conta.getValor() > 0) {
			contaRepository.saque(conta.getAgencia(), conta.getConta(), conta.getValor());
		}else {
			System.out.println("SAQUES DEVEM SER MAIOR QUE R$ 0.0");
		}
		
	}
	
	public double consultarSaldo(String agencia, String conta) {
		ContaBancariaModel contaBancaria = new ContaBancariaModel();
		contaBancaria = contaRepository.consultarConta(agencia, conta);
		
		return contaBancaria.getSaldo();
	}
	
	public List<MovimentacoesConta> consultarMovimentacoes(String agencia, String conta) {
		return contaRepository.consultarMovimentacoes(agencia, conta);
	}
}
