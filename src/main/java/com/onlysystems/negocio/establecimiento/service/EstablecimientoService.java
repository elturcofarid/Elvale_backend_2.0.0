package com.onlysystems.negocio.establecimiento.service;

import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;

import java.util.List;
import java.util.UUID;

public interface EstablecimientoService {

     List<EstablecimientoDto> consultar();

     EstablecimientoDto consultarId(EstablecimientoDto establecimientoDto);

     UUID registrar(EstablecimientoDto empresa);

     void actualizar(EstablecimientoDto empresa);

}
