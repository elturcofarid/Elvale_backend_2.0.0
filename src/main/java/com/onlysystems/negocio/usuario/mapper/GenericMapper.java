package com.onlysystems.negocio.usuario.mapper;

import org.modelmapper.ModelMapper;

public class GenericMapper<Clasedto, Claseentity> {

    private final ModelMapper modelMapper;

    public GenericMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Claseentity mapDtoToEntity(Clasedto dto, Class<Claseentity> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public Clasedto mapEntityToDto(Claseentity entity, Class<Clasedto> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
