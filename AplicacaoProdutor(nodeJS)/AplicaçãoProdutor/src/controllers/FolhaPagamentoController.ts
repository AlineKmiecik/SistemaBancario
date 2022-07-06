import axios from "axios";
import { json, Request, Response } from "express";
import { FolhaPagamentoRepository } from "../repositories/FolhaPagamentoRepository";
import { RabbitMQService } from "./RabbitMQ";

const folhaPagamentoRepository = new FolhaPagamentoRepository();
const rabbitMQService = new RabbitMQService();
export class FolhaPagamentoController {
  
  cadastrar(request: Request, response: Response) {
    const folha = request.body;
     rabbitMQService.publishCadastro(folhaPagamentoRepository.calcular(folha));
    response.status(201).json({ message: "Folha cadastrada", data: folha });
  }

  

}
