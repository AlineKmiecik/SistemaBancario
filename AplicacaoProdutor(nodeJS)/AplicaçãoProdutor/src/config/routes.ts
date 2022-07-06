import { ContaController } from './../controllers/contaController';
import { Router } from "express";

const routes = Router();

//Default
routes.get("/", (request, response) => {
  response.json({ message: "API de Contas Bancarias" });
});

//Produto
routes.post("/conta/cadastrar", new ContaController().cadastrar);
routes.put("/conta/depositar/:agencia/:conta/:valor", new ContaController().depositar);
routes.put("/conta/sacar/:agencia/:conta/:valor", new ContaController().sacar);


/* routes.get("/folha/calcular", new FolhaPagamentoController().calcular);
routes.get("/folha/listar", new FolhaPagamentoController().listar);
routes.get("/folha/listarprocessadas", new FolhaPagamentoController().listarProcessadas);
//routes.delete("/produto/deletar/:id", new ProdutoController().deletar); */

export { routes };
