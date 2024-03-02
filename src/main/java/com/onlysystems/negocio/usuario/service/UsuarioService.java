package com.onlysystems.negocio.usuario.service;

import com.onlysystems.negocio.usuario.entity.UsuarioDto;

import java.util.List;

public interface UsuarioService {

     List<UsuarioDto> consultar();

     UsuarioDto consultarId(UsuarioDto usuario);

     void registrar(UsuarioDto usuarioDto);

     void actualizar(UsuarioDto usuarioDto);

}
