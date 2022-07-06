package com.folhaPagamentoCadastro.folhaPagamentoCadastro.RabbitMQ;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.config.RabbitMQConfig;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.ContaBancariaModel;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.service.ContaBancariaService;
import org.springframework.amqp.core.Message;

@Component
public class RabbitMQConsume {
	@Autowired
    ContaBancariaService contaBancariaService;
	
	RabbitMQConfig config = new RabbitMQConfig();

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listener(@Payload Message message) throws StreamReadException, DatabindException, IOException{
    	System.out.println("MENSAGEM RECEBIDA CADASTRO");
		
    	ContaBancariaModel conta = new ContaBancariaModel();
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        conta = objectMapper.readValue(message.getBody(), ContaBancariaModel.class);
        
        contaBancariaService.cadastrarConta(conta);
    }  
    
    @RabbitListener(queues = "${spring.rabbitmq.queue2}")
    public void listener2(@Payload Message message) throws StreamReadException, DatabindException, IOException{
    	System.out.println("MENSAGEM RECEBIDA DEPOSITO");
    	
    	ContaBancariaModel conta = new ContaBancariaModel();
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        conta = objectMapper.readValue(message.getBody(), ContaBancariaModel.class);
        
        contaBancariaService.realizarDeposito(conta);
         
    } 
    
    @RabbitListener(queues = "${spring.rabbitmq.queue3}")
    public void listener3(@Payload Message message) throws StreamReadException, DatabindException, IOException{
    	System.out.println("MENSAGEM RECEBIDA SAQUE");
    	
    	ContaBancariaModel conta = new ContaBancariaModel();
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        conta = objectMapper.readValue(message.getBody(), ContaBancariaModel.class);
        
        contaBancariaService.realizarSaque(conta);
    } 

}
