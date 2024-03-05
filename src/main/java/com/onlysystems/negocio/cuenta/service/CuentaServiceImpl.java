package com.onlysystems.negocio.cuenta.service;

import com.onlysystems.negocio.cuenta.entity.CuentaDto;
import com.onlysystems.negocio.cuenta.entity.CuentaModel;
import com.onlysystems.negocio.cuenta.mapper.GenericMapper;
import com.onlysystems.negocio.cuenta.repository.CuentaRepository;
import com.onlysystems.negocio.exepcion.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuentaServiceImpl implements CuentaService {


    @Autowired
    private CuentaRepository usuarioRepository;

    GenericMapper<CuentaDto, CuentaModel> mapper = new GenericMapper<>();


    @Override
    public List<CuentaDto> consultar() {
        List<CuentaDto> usuarios = new ArrayList<>();
        usuarioRepository.findAll().stream().forEach(
                usuario -> usuarios.add(mapper.mapEntityToDto(usuario, CuentaDto.class ))
                );

        return usuarios;
    }



    @Override
    public CuentaDto consultarId(CuentaDto usuarioDto) {
        Optional<CuentaModel> usuarioModel = usuarioRepository.findById(usuarioDto.getId());
        if (usuarioModel.isEmpty()) {
            throw new CustomException("No se encontro el usuario");
        }
        return mapper.mapEntityToDto(usuarioModel.get(), CuentaDto.class );
    }

    @Override
    public List<CuentaDto> consultarCuentasUsuario(CuentaDto cuentaDto) {
        List<CuentaModel> cuentas = usuarioRepository.findByCliente(mapper.mapDtoToEntity(cuentaDto, CuentaModel.class).getCliente());
        List<CuentaDto> respuesta = new ArrayList<>();
        cuentas.stream().forEach(
                cuenta -> respuesta.add(mapper.mapEntityToDto(cuenta, CuentaDto.class))
        );

        return respuesta;
    }


    @Override
    public UUID registrar(CuentaDto cuentaDto) {
        return usuarioRepository.save(mapper.mapDtoToEntity(cuentaDto, CuentaModel.class)).getId();
    }

    @Override
    public void actualizar(CuentaDto fiao) {
        throw new UnsupportedOperationException();
    }

}

