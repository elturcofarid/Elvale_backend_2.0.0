package com.onlysystems.negocio.usuario.service;

import com.onlysystems.negocio.usuario.entity.UsuarioDto;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

     List<UsuarioDto> consultar();

     UsuarioDto consultarId(UsuarioDto usuario);

     UUID registrar(UsuarioDto usuarioDto);

     void actualizar(UsuarioDto usuarioDto);

}
