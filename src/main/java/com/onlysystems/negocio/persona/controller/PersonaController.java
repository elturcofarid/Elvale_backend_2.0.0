package com.onlysystems.negocio.persona.controller;

import com.onlysystems.negocio.persona.entity.PersonaDto;
import com.onlysystems.negocio.persona.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persona")
//@CrossOrigin(origins = "http://localhost:3000")
public class PersonaController {

    private static Logger logger = LoggerFactory.getLogger(PersonaController.class);

      @Autowired
    private PersonaService personaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody PersonaDto persona){
        logger.info("Registrando un persona");
        return new ResponseEntity<>(personaService.registrar(persona), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> consultar(){
        logger.info("Consultando un persona");
        personaService.consultar();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /*
    @PostMapping("/pagar")
    public ResponseEntity<?> pagarFiao(){
        logger.info("Pagando un fiao");

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    */



    @PutMapping()
    public ResponseEntity<?> actualizar(){
        logger.info("Actualizar un cliente");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
