package com.onlysystems.negocio.usuario.entity;
import java.util.UUID;

public class UsuarioDto {

    private UUID id;

    private String nombre;

    private String email;

    private UUID rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getRol() {
        return rol;
    }

    public void setRol(UUID rol) {
        this.rol = rol;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
