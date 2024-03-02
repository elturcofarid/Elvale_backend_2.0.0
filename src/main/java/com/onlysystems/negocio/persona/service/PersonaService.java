package com.onlysystems.negocio.persona.service;

import com.onlysystems.negocio.persona.entity.PersonaDto;
import java.util.List;
import java.util.UUID;

public interface PersonaService {

     List<PersonaDto> consultar();

     UUID registrar(PersonaDto cleinte);

     void actualizar(PersonaDto cleinte);

}
