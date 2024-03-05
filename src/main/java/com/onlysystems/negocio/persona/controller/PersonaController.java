package com.onlysystems.negocio.persona.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.comunes.ResponseDTO;
import com.onlysystems.negocio.exepcion.CustomException;
import com.onlysystems.negocio.persona.entity.PersonaDto;
import com.onlysystems.negocio.persona.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonaController {

    private static Logger logger = LoggerFactory.getLogger(PersonaController.class);

    private Gson gson = new Gson();

    @Autowired
    private PersonaService personaService;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody PersonaDto persona){
        logger.info("Registrando un persona");

        UUID uuid;
        try {
            uuid = personaService.registrar(persona);
        }catch (Exception e){
            throw new CustomException(gson.toJson(new ResponseDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Se presento un error al crear Persona",
                    null
            )));
        }

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Persona registrada exitosamente",
                uuid
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
