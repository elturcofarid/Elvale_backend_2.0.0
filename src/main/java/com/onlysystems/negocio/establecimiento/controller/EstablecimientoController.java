package com.onlysystems.negocio.establecimiento.controller;

import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;
import com.onlysystems.negocio.establecimiento.service.EstablecimientoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/establecimiento")
//@CrossOrigin(origins = "http://localhost:3000")
public class EstablecimientoController {

    private static Logger logger = LoggerFactory.getLogger(EstablecimientoController.class);

      @Autowired
    private EstablecimientoService establecimientoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody EstablecimientoDto establecimientoDto){

        logger.info("Registrando un establecimiento");
        return new ResponseEntity<>(establecimientoService.registrar(establecimientoDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> consultar(){
        logger.info("Consultando un establecimiento");

        return new ResponseEntity<>(establecimientoService.consultar(), HttpStatus.OK);
    }

    /*
    @PostMapping("/pagar")
    public ResponseEntity<?> pagarFiao(){
        logger.info("Pagando un fiao");

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    */



    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(){
        logger.info("Actualizar un establecimiento");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
