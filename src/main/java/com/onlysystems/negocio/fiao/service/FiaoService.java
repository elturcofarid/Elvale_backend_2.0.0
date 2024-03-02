package com.onlysystems.negocio.fiao.service;

import com.onlysystems.negocio.cuenta.entity.CuentaDto;
import com.onlysystems.negocio.fiao.entity.FiaoDto;

import java.util.List;
import java.util.UUID;

public interface FiaoService {

     List<FiaoDto> consultarFiao();

     UUID registrar(FiaoDto fiao);

     void actualizar(FiaoDto fiao);


}
