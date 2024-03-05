package com.onlysystems.negocio.usuario.service;

import com.onlysystems.negocio.persona.entity.PersonaDto;
import com.onlysystems.negocio.persona.entity.PersonaModel;
import com.onlysystems.negocio.usuario.entity.UsuarioDto;
import com.onlysystems.negocio.usuario.entity.UsuarioModel;
import com.onlysystems.negocio.usuario.mapper.GenericMapper;
import com.onlysystems.negocio.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    GenericMapper<UsuarioDto, UsuarioModel> mapper = new GenericMapper<>();


    @Override
    public List<UsuarioDto> consultar() {
        List<UsuarioDto> usuarios = new ArrayList<>();
        usuarioRepository.findAll().stream().forEach(
                usuario -> usuarios.add(mapper.mapEntityToDto(usuario, UsuarioDto.class ))
                );

        return usuarios;
    }

    @Override
    public UsuarioDto consultarId(UsuarioDto usuarioDto) {
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(usuarioDto.getId());
        return mapper.mapEntityToDto(usuarioModel.get(), UsuarioDto.class );
    }


    @Override
    public UUID registrar( UsuarioDto usuarioDto) {
        return usuarioRepository.save(mapper.mapDtoToEntity(usuarioDto, UsuarioModel.class)).getId();
    }


    @Override
    public void actualizar(UsuarioDto fiao) {

    }

}

