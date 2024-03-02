package com.onlysystems.negocio.establecimiento.entity;

import com.onlysystems.negocio.persona.entity.PersonaDto;
import com.onlysystems.negocio.persona.entity.PersonaModel;

import java.util.UUID;

public class EstablecimientoDto {

    private UUID id;

    private String nombre;

    private String direccion;

    private String telefono;

    private PersonaDto propietario;

    private Integer nit;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public PersonaDto getPropietario() {
        return propietario;
    }

    public void setPropietario(PersonaDto propietario) {
        this.propietario = propietario;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
