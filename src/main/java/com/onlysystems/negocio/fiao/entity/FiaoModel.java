package com.onlysystems.negocio.fiao.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "fiao")
public class FiaoModel {


    @Id
    @GeneratedValue()
    private UUID id;

    private UUID cuenta;

    private double valor;

    private UUID grabador;

    private Instant fecha;
    
    private UUID estado;

    public UUID getEstado() {
        return estado;
    }

    public void setEstado(UUID estado) {
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCuenta() {
        return cuenta;
    }

    public void setCuenta(UUID cuenta) {

        this.cuenta = cuenta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UUID getGrabador() {
        return grabador;
    }

    public void setGrabador(UUID grabador) {
        this.grabador = grabador;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = Instant.now();
    }

}
