package com.onlysystems.negocio.cliente.entity;


import com.onlysystems.negocio.persona.entity.PersonaModel;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class CLienteModel {


    @Id
    @GeneratedValue()
    private UUID id;

    @OneToOne
    private PersonaModel cliente;

    @ManyToOne
    private PersonaModel referencia;

    public PersonaModel getCliente() {
        return cliente;
    }

    public void setCliente(PersonaModel cliente) {
        this.cliente = cliente;
    }

    public PersonaModel getReferencia() {
        return referencia;
    }

    public void setReferencia(PersonaModel referencia) {
        this.referencia = referencia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CLienteModel() {

    }


}
