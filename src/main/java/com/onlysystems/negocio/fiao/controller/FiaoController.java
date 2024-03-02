package com.onlysystems.negocio.fiao.controller;

import com.onlysystems.negocio.fiao.entity.FiaoDto;
import com.onlysystems.negocio.fiao.service.FiaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/fiao")
//@CrossOrigin(origins = "http://localhost:3000")
public class FiaoController {

    private static Logger logger = LoggerFactory.getLogger(FiaoController.class);

      @Autowired
    private FiaoService fiaoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarFiao(@RequestBody FiaoDto fiaoDto){
        logger.info("Registrando un fiao");
        return new ResponseEntity<>(fiaoService.registrar(fiaoDto), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarFiao(){
        logger.info("Consultando un fiao");

        return new ResponseEntity<>(fiaoService.consultarFiao(), HttpStatus.OK);
    }





    /*
    @PostMapping("/pagar")
    public ResponseEntity<?> pagarFiao(){
        logger.info("Pagando un fiao");

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    */



    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarFiao(){
        logger.info("Actualizar un fiao");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
