package com.onlysystems.negocio.cuenta.mapper;

import org.modelmapper.ModelMapper;

public class GenericMapper<DTO, Entity> {

    private final ModelMapper modelMapper;

    public GenericMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Entity mapDtoToEntity(DTO dto, Class<Entity> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public DTO mapEntityToDto(Entity entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
