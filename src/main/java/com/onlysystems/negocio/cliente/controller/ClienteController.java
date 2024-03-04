package com.onlysystems.negocio.cliente.controller;

import com.onlysystems.negocio.cliente.entity.ClienteDto;
import com.onlysystems.negocio.cliente.service.ClienteService;
import com.onlysystems.negocio.comunes.ResponseDTO;
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
    public ResponseEntity<ResponseDTO> registrarCliente(@RequestBody ClienteDto clienteDto){
        logger.info("Registrando un cliente" );

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "CLiente registrado exitosamente",
                clienteService.registrar(clienteDto)
        ), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ResponseDTO> consultar(){
        logger.info("Consultando un cliente");
        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                clienteService.consultarCliente()
        ), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizarCliente(){
        logger.info("Actualizar un cliente");
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }
}
