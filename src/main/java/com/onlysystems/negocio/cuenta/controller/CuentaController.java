package com.onlysystems.negocio.cuenta.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.cuenta.entity.CuentaDto;
import com.onlysystems.negocio.cuenta.service.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuenta")
//@CrossOrigin(origins = "http://localhost:3000")
public class CuentaController {

    private static Logger logger = LoggerFactory.getLogger(CuentaController.class);

    private Gson gson = new Gson();

      @Autowired
    private CuentaService cuentaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody CuentaDto cuentaDto){
        logger.info("Registrando un cuenta" );
        return new ResponseEntity<>(cuentaService.registrar(cuentaDto), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultar(){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(gson.toJson(cuentaService.consultar()), HttpStatus.OK);
    }

    @GetMapping("/consultar/id")
    public ResponseEntity<?> consultar(@RequestBody CuentaDto cuentaDto){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(gson.toJson(cuentaService.consultarId(cuentaDto)), HttpStatus.OK);
    }

    @GetMapping("/consultar/usuario")
    public ResponseEntity<?> consultarCuentasUsuario(@RequestBody CuentaDto cuentaDto){
        logger.info("Consultando un cuentas por usuario");
        return new ResponseEntity<>(gson.toJson(cuentaService.consultarCuentasUsuario(cuentaDto)), HttpStatus.OK);
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
