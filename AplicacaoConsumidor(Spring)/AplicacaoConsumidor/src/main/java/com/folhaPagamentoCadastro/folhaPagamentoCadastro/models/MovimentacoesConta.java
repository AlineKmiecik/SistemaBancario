package com.folhaPagamentoCadastro.folhaPagamentoCadastro.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MovimentacoesConta implements Serializable {
	private ContaBancariaModel conta;
	private LocalDateTime data;
	private String Movimentacao;
	private double valor;
	
	public MovimentacoesConta() {
		conta = new ContaBancariaModel();
		data = LocalDateTime.MAX;
		Movimentacao = "";
		valor = 0.0;
	}

	public ContaBancariaModel getConta() {
		return conta;
	}

	public void setConta(ContaBancariaModel conta) {
		this.conta = conta;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getMovimentacao() {
		return Movimentacao;
	}

	public void setMovimentacao(String movimentacao) {
		Movimentacao = movimentacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
