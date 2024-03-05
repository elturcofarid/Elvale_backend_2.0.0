package com.onlysystems.negocio.persona.service;

import com.onlysystems.negocio.exepcion.CustomException;
import com.onlysystems.negocio.persona.entity.PersonaDto;
import com.onlysystems.negocio.persona.entity.PersonaModel;
import com.onlysystems.negocio.persona.repository.PersonaRepository;
import com.onlysystems.negocio.usuario.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonaServiceImpl implements PersonaService {

    GenericMapper<PersonaDto, PersonaModel> mapper = new GenericMapper<>();

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaDto> consultar (){
        List<PersonaDto> personaDtoList = new ArrayList<>();
        personaRepository.findAll().stream().forEach(
                fiao -> personaDtoList.add(mapper.mapEntityToDto(fiao, PersonaDto.class)));
        return personaDtoList;
    }

    @Override
    public PersonaDto consultarId(PersonaDto personaDto){
        Optional<PersonaModel> persona = personaRepository.findById(personaDto.getId());
        if (persona.isEmpty()) {
            throw new CustomException("No se encontro persona");
        }
        return mapper.mapEntityToDto(persona.get(), PersonaDto.class);
    }

    @Override
    public UUID registrar(PersonaDto persona) {
        return personaRepository.save(mapper.mapDtoToEntity(persona, PersonaModel.class)).getId();
    }

    @Override
    public void actualizar(PersonaDto persona) {
        throw new UnsupportedOperationException();
    }
}
