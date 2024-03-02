package com.onlysystems.negocio.cuenta.entity;

import com.onlysystems.negocio.cliente.entity.ClienteDto;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import com.onlysystems.negocio.fiao.entity.FiaoDto;
import com.onlysystems.negocio.fiao.entity.FiaoModel;
import com.onlysystems.negocio.usuario.entity.UsuarioDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuentaDto {

    private UUID id;

    private ClienteDto cliente;

    private String alias;

    private double creditoAprobado;

    private EstablecimientoDto establecimiento;

    public EstablecimientoDto getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoDto establecimiento) {
        this.establecimiento = establecimiento;
    }

    private List<FiaoModel> fiaos = new ArrayList<>();


    public List<FiaoModel> getFiaos() {
        return fiaos;
    }

    public void setFiaos(List<FiaoModel> fiaos) {
        this.fiaos = fiaos;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getCreditoAprobado() {
        return creditoAprobado;
    }


    public void setCreditoAprobado(double creditoAprobado) {
        this.creditoAprobado = creditoAprobado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }
}
