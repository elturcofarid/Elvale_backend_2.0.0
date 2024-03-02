package com.onlysystems.negocio.cuenta.service;

import com.onlysystems.negocio.cuenta.entity.CuentaDto;

import java.util.List;
import java.util.UUID;

public interface CuentaService {

     List<CuentaDto> consultar();

     CuentaDto consultarId(CuentaDto cuenta);

     UUID registrar(CuentaDto cuenta);

     void actualizar(CuentaDto cuenta);

     List<CuentaDto> consultarCuentasUsuario(CuentaDto cuenta);

}
