package com.onlysystems.negocio.persona.controller;

import com.onlysystems.negocio.comunes.ResponseDTO;
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
@CrossOrigin(origins = "http://localhost:3000")
public class PersonaController {

    private static Logger logger = LoggerFactory.getLogger(PersonaController.class);

      @Autowired
    private PersonaService personaService;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody PersonaDto persona){
        logger.info("Registrando un persona");
        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Persona registrada exitosamente",
                personaService.registrar(persona)
        ), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> consultar(){
        logger.info("Consultando un persona");

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                personaService.consultar()
        ), HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<ResponseDTO> consultarId(@RequestBody PersonaDto personaDto){
        logger.info("Consultando un persona");
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.OK.value(),
                        "Consulta ejecutada exitosamente",
                        personaService.consultarId(personaDto)
                ), HttpStatus.OK);
    }


    @PutMapping()
    public ResponseEntity<ResponseDTO> actualizar(){
        logger.info("Actualizar un cliente");
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }
}
