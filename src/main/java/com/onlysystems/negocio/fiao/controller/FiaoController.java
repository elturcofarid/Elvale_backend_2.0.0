package com.onlysystems.negocio.fiao.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.comunes.ResponseDTO;
import com.onlysystems.negocio.exepcion.CustomException;
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

    private Gson gson = new Gson();

      @Autowired
    private FiaoService fiaoService;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrarFiao(@RequestBody FiaoDto fiaoDto){
        logger.info("Registrando un fiao");
        UUID uuid;
        try {
            uuid = fiaoService.registrar(fiaoDto);
        }catch (Exception e){
            throw new CustomException(gson.toJson(new ResponseDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Se presento un error al crear fiao",
                    null
            )));
        }
        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Fiao registrado exitosamente",
                uuid
        ), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarFiao(){
        logger.info("Consultando un fiao");

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Consulta ejecutada exitosamente",
                fiaoService.consultarFiao()
        ), HttpStatus.CREATED);
    }


    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizarFiao(){
        logger.info("Actualizar un fiao");
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }
}
