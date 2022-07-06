package com.folhaPagamentoCadastro.folhaPagamentoCadastro.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.ContaBancariaModel;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.MovimentacoesConta;

public class ContaBancariaRepository {
	private List<ContaBancariaModel> contas;
	private List<MovimentacoesConta> movimentacoes;
	private int indexConta;
	
	public ContaBancariaRepository() {
		contas = new ArrayList<>();
		movimentacoes = new ArrayList<>();
	}
	
	public void cadastrarConta(ContaBancariaModel conta) {
		contas.add(conta);
		System.out.println("Conta cadastrada");
	}
	
	public void deposito(String agencia, String conta, double valor) {
		indexConta = 0;
		for (ContaBancariaModel contaBancaria : contas) {
			if(indexConta != 0) {
				indexConta ++;
			}
			
			if(contaBancaria.getAgencia().equalsIgnoreCase(agencia) &&
					contaBancaria.getConta().equalsIgnoreCase(conta) ) {
				contaBancaria.setSaldo(contaBancaria.getSaldo() + valor);
				contas.set(indexConta, contaBancaria);
				
				
				this.cadastrarMovimentacao(contaBancaria, "DEPOSITO", valor);
				
				System.out.println("DEPOSITO EFETUADO DE R$" + valor );
			}
		}
	}
	
	public void saque(String agencia, String conta, double valor) {
		indexConta = 0;
		
		for (ContaBancariaModel contaBancaria : contas) {
			if(indexConta != 0) {
				indexConta ++;
			}
			
			if(contaBancaria.getAgencia().equalsIgnoreCase(agencia) &&
					contaBancaria.getConta().equalsIgnoreCase(conta) ) {
				
				if(contaBancaria.getSaldo() >= valor) {
					contaBancaria.setSaldo(contaBancaria.getSaldo() - valor);
					contas.set(indexConta, contaBancaria);
					this.cadastrarMovimentacao(contaBancaria, "SAQUE", valor);
					
					System.out.println("SALDO EFETUADO DE R$" + valor );
				}
			}else {
				System.out.println("NÃO FOI POSSIVEL EFETUAR O SAQUE, SALDO INSUFICIENTE");
			}
		}
	}
	
	public ContaBancariaModel consultarConta(String agencia, String conta) {
		indexConta = 0;
		
		for (ContaBancariaModel contaBancaria : contas) {
			if(indexConta != 0) {
				indexConta ++;
			}
			
			if(contaBancaria.getAgencia().equalsIgnoreCase(agencia) &&
					contaBancaria.getConta().equalsIgnoreCase(conta) ) {
				
				return contaBancaria;
			}
		}
		
		return new ContaBancariaModel();
	}
	
	public List<MovimentacoesConta> consultarMovimentacoes(String agencia, String conta) {
		indexConta = 0;
		List<MovimentacoesConta> movsConta = new ArrayList<>();
		
		for (MovimentacoesConta movimentacao : movimentacoes) {
			if(indexConta != 0) {
				indexConta ++;
			}
			
			if(movimentacao.getConta().getAgencia().equalsIgnoreCase(agencia) &&
					movimentacao.getConta().getConta().equalsIgnoreCase(conta) ) {
				
				movsConta.add(movimentacao);
			}
		}
		
		return movsConta;
	}
	
	public void cadastrarMovimentacao(ContaBancariaModel conta, String movimentacao, double valor) {
		MovimentacoesConta mov = new MovimentacoesConta();
		mov.setConta(conta);
		mov.setData(LocalDateTime.now());
		mov.setMovimentacao(movimentacao);
		mov.setValor(valor);
		
		movimentacoes.add(mov);
	}
}
