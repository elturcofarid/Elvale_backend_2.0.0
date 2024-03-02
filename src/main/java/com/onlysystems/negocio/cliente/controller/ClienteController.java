package com.onlysystems.negocio.cliente.controller;

import com.onlysystems.negocio.cliente.entity.ClienteDto;
import com.onlysystems.negocio.cliente.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
//@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    private static Logger logger = LoggerFactory.getLogger(ClienteController.class);

      @Autowired
    private ClienteService clienteService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@RequestBody ClienteDto clienteDto){
        logger.info("Registrando un cliente" + clienteDto.toString());

        return new ResponseEntity<>(clienteService.registrar(clienteDto), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultar(){
        logger.info("Consultando un cliente");
        return new ResponseEntity<>(clienteService.consultarCliente(), HttpStatus.OK);
    }

    /*
    @PostMapping("/pagar")
    public ResponseEntity<?> pagarFiao(){
        logger.info("Pagando un fiao");

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    */



    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarCliente(){
        logger.info("Actualizar un cliente");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
