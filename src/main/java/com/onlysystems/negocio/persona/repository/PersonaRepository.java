package com.onlysystems.negocio.persona.repository;

import com.onlysystems.negocio.persona.entity.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonaRepository extends JpaRepository<PersonaModel, UUID> {

}
