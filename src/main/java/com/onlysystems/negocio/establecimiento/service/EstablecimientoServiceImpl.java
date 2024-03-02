package com.onlysystems.negocio.establecimiento.service;

import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;
import com.onlysystems.negocio.establecimiento.repository.EstablecimientoRepository;
import com.onlysystems.negocio.usuario.entity.UsuarioDto;
import com.onlysystems.negocio.usuario.entity.UsuarioModel;
import com.onlysystems.negocio.usuario.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService {


    GenericMapper<EstablecimientoDto, EstablecimientoModel> mapper = new GenericMapper<>();

    @Autowired
    private EstablecimientoRepository empresaRepository;

    @Override
    public List<EstablecimientoDto> consultar() {
        empresaRepository.findAll().stream().forEach(fiao -> System.out.println("Este es el id del fio::: "+ fiao.getId()));
        return null;
    }

    @Override
    public UUID registrar(EstablecimientoDto establecimientoDto) {
        return empresaRepository.save(mapper.mapDtoToEntity(establecimientoDto, EstablecimientoModel.class)).getId();
    }

    @Override
    public void actualizar(EstablecimientoDto fiao) {

    }
}
