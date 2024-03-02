package com.onlysystems.negocio.cliente.service;

import com.onlysystems.negocio.cliente.entity.ClienteDto;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

     List<ClienteDto> consultarCliente();

     UUID registrar(ClienteDto cleinte);

     void actualizar(ClienteDto cleinte);

}
