package com.onlysystems.negocio.establecimiento.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.comunes.ResponseDTO;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;
import com.onlysystems.negocio.establecimiento.service.EstablecimientoService;
import com.onlysystems.negocio.exepcion.CustomException;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/establecimiento")
//@CrossOrigin(origins = "http://localhost:3000")
public class EstablecimientoController {

    private static Logger logger = LoggerFactory.getLogger(EstablecimientoController.class);

    private Gson gson = new Gson();

      @Autowired
    private EstablecimientoService establecimientoService;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody EstablecimientoDto establecimientoDto){
        logger.info("Registrando un establecimiento");
        UUID uuid;

        try {
             uuid = establecimientoService.registrar(establecimientoDto);
        }catch (Exception e){
            throw new CustomException(gson.toJson(new ResponseDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Se presento un error al crear establecimiento",
                            null
            )));
        }
        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Establecimiento creado exitosamente",
                uuid
        ), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> consultar(){
        logger.info("Consultando un establecimiento");
        return new ResponseEntity<>(new ResponseDTO (
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                establecimientoService.consultar()
        ), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<ResponseDTO> consultarId(@RequestBody EstablecimientoDto establecimientoDto){
        logger.info("Consultando un establecimiento");
        return new ResponseEntity<>(new ResponseDTO (
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                establecimientoService.consultarId(establecimientoDto)
        ), HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizar(){
        logger.info("Actualizar un establecimiento");
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }
}
