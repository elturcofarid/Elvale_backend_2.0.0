package com.onlysystems.negocio.usuario.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.comunes.ResponseDTO;
import com.onlysystems.negocio.exepcion.CustomException;
import com.onlysystems.negocio.usuario.entity.UsuarioDto;
import com.onlysystems.negocio.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
//@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private Gson gson = new Gson();

      @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody UsuarioDto usuarioDto){
        logger.info("Registrando un establecimiento");
        UUID uuid;
        try {
            uuid = usuarioService.registrar(usuarioDto);
        }catch (Exception e){
            throw new CustomException(gson.toJson(new ResponseDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Se presento un error al crear usuario",
                    null
            )));
        }

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Se creo usuario correctamente",
                uuid
        ), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ResponseDTO> consultar(){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.OK.value(),
                        "Consulta ejecutada exitosamente",
                        gson.toJson(usuarioService.consultar())
                ), HttpStatus.OK);
    }

    @GetMapping("/consultar/id")
    public ResponseEntity<ResponseDTO> consultarId(@RequestBody UsuarioDto usuarioDto){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.OK.value(),
                        "Consulta ejecutada exitosamente",
                        gson.toJson(usuarioService.consultarId(usuarioDto))
                ), HttpStatus.OK);
    }


    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizar(){
        logger.info("Actualizar un establecimiento");
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }
}
