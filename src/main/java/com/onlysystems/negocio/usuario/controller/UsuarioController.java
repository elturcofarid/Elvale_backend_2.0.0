package com.onlysystems.negocio.usuario.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.usuario.entity.UsuarioDto;
import com.onlysystems.negocio.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
//@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private Gson gson = new Gson();

      @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody UsuarioDto usuarioDto){
        logger.info("Registrando un establecimiento" + usuarioDto.getNombre());
        usuarioService.registrar(usuarioDto);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultar(){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(gson.toJson(usuarioService.consultar()), HttpStatus.OK);
    }

    @GetMapping("/consultar/id")
    public ResponseEntity<?> consultar(@RequestBody UsuarioDto usuarioDto){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(gson.toJson(usuarioService.consultarId(usuarioDto)), HttpStatus.OK);
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
