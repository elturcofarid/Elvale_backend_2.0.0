package com.onlysystems.negocio.establecimiento.entity;

import com.onlysystems.negocio.persona.entity.PersonaDto;

import java.time.Instant;
import java.util.UUID;

public class EstablecimientoDto {

    private UUID id;

    private String nombre;

    private String direccion;

    private String telefono;

    private PersonaDto propietario;

    private Integer nit;

    private Instant fechaCreacion;

    private Instant fechaModificacion;

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Instant getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Instant fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

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
