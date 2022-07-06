package com.folhaPagamentoCadastro.folhaPagamentoCadastro.models;

import java.io.Serializable;

public class ContaBancariaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
    private String cpf;
    private String agencia;
    private String conta;
    private double saldo;
    private double valor;
    
    public ContaBancariaModel() {
    	nome = "";
    	cpf = "";
    	agencia = "";
    	conta = "";
    	saldo = 0.0;
    	valor = 0.0;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
