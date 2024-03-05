package com.onlysystems.negocio.cuenta.controller;

import com.google.gson.Gson;
import com.onlysystems.negocio.comunes.ResponseDTO;
import com.onlysystems.negocio.cuenta.entity.CuentaDto;
import com.onlysystems.negocio.cuenta.service.CuentaService;
import com.onlysystems.negocio.exepcion.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cuenta")
//@CrossOrigin(origins = "http://localhost:3000")
public class CuentaController {

    private static Logger logger = LoggerFactory.getLogger(CuentaController.class);

    private Gson gson = new Gson();

      @Autowired
    private CuentaService cuentaService;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody CuentaDto cuentaDto){
        logger.info("Registrando un cuenta" );

        UUID uuid;
        try {
            uuid = cuentaService.registrar(cuentaDto);
        }catch (Exception e){
            throw new CustomException(gson.toJson(new ResponseDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Se presento un error al crear cuenta",
                    null
            )));
        }

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.CREATED.value(),
                "Cuenta creada exitosamente",
                uuid
        ), HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ResponseDTO> consultar(){
        logger.info("Consultando un usuaerios");

        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                gson.toJson(cuentaService.consultar())
        ), HttpStatus.OK);
    }

    @GetMapping("/consultar/id")
    public ResponseEntity<ResponseDTO> consultarId(@RequestBody CuentaDto cuentaDto){
        logger.info("Consultando un usuaerios");
        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                gson.toJson(cuentaService.consultarId(cuentaDto))
        ), HttpStatus.OK);
    }

    @GetMapping("/consultar/usuario")
    public ResponseEntity<ResponseDTO> consultarCuentasUsuario(@RequestBody CuentaDto cuentaDto){
        logger.info("Consultando un cuentas por usuario");
        return new ResponseEntity<>(new ResponseDTO(
                HttpStatus.OK.value(),
                "Consulta ejecutada exitosamente",
                gson.toJson(cuentaService.consultarCuentasUsuario(cuentaDto))
        ), HttpStatus.OK);
    }


    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizar(){
        logger.info("Actualizar un establecimiento");
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }
}
