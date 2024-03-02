package com.onlysystems.negocio.cliente.service;

import com.onlysystems.negocio.cliente.entity.CLienteModel;
import com.onlysystems.negocio.cliente.entity.ClienteDto;
import com.onlysystems.negocio.cliente.repository.ClienteRepository;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import com.onlysystems.negocio.usuario.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    GenericMapper<ClienteDto, CLienteModel> mapper = new GenericMapper<>();


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDto> consultarCliente() {
        List<ClienteDto> resultado = new ArrayList<>();
        clienteRepository.findAll().stream().forEach(cliente ->
                resultado.add(mapper.mapEntityToDto(cliente, ClienteDto.class)));
        return resultado;
    }

    @Override
    public UUID registrar(ClienteDto clienteDto) {
        return clienteRepository.save(mapper.mapDtoToEntity(clienteDto, CLienteModel.class)).getId();
    }

    @Override
    public void actualizar(ClienteDto fiao) {

    }
}
