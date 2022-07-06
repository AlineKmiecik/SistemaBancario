import { Conta } from './../models/conta';
import { ContaRepository } from './../repositories/contaRepository';
import { json, Request, Response } from "express";
import { RabbitMQService } from "./RabbitMQ";

const contaRepository = new ContaRepository();

const rabbitMQService = new RabbitMQService();

export class ContaController {

  cadastrar(request: Request, response: Response) {
    console.log(request.body);

    let contareq: Conta = new Conta();
    contareq = request.body;

    rabbitMQService.publishCadastro(contareq);
    response.status(201).json({ message: "Conta Cadastrada", data: contareq });
  }

  depositar(request: Request, response: Response) {
    console.log(request.params.agencia);
    console.log(request.params.conta);
    console.log(request.params.valor);

    let contareq: Conta = new Conta();

    contareq.agencia = (request.params.agencia);
    contareq.conta = (request.params.conta);
    contareq.valor = Number.parseFloat(request.params.valor);

    rabbitMQService.publishDeposito(contareq);
    response.status(201).json({ message: "Deposito realizado", data: contareq });
  }
  
  sacar(request: Request, response: Response) {
    console.log(request.params.agencia);
    console.log(request.params.conta);
    console.log(request.params.valor);

    let contareq: Conta = new Conta();

    contareq.agencia = (request.params.agencia);
    contareq.conta = (request.params.conta);
    contareq.valor = Number.parseFloat(request.params.valor);

    rabbitMQService.publishSaque(contareq);

    //validação por get
    response.status(201).json({ message: "Saque", data: contareq });
  }

}