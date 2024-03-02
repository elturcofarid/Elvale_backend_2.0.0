package com.onlysystems.negocio.cliente.entity;

import com.onlysystems.negocio.persona.entity.PersonaDto;
import java.util.UUID;

public class ClienteDto {

    private UUID id;

    private PersonaDto cliente;

    private PersonaDto referencia;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PersonaDto getCliente() {
        return cliente;
    }

    public void setCliente(PersonaDto cliente) {
        this.cliente = cliente;
    }

    public PersonaDto getReferencia() {
        return referencia;
    }

    public void setReferencia(PersonaDto referencia) {
        this.referencia = referencia;
    }
}
