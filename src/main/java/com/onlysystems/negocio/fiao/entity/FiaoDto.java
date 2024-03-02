package com.onlysystems.negocio.fiao.entity;

import com.onlysystems.negocio.cuenta.entity.CuentaDto;

import java.sql.Timestamp;
import java.util.UUID;

public class FiaoDto {

    private UUID id;

    private UUID cuenta;

    private double valor;

    private UUID grabador;

    private Timestamp fecha;

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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {

        this.fecha = fecha;
    }

}
