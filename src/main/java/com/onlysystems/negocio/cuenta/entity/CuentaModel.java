package com.onlysystems.negocio.cuenta.entity;

import com.onlysystems.negocio.cliente.entity.CLienteModel;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import com.onlysystems.negocio.fiao.entity.FiaoModel;
import com.onlysystems.negocio.usuario.entity.UsuarioModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cuenta")
public class CuentaModel {


    @Id
    @GeneratedValue()
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private CLienteModel cliente;

    @OneToMany
    @JoinColumn(name = "cuenta")
    private List<FiaoModel> fiaos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "establecimiento")
    private EstablecimientoModel establecimiento;

    private String alias;

    private double creditoAprobado;



    public EstablecimientoModel getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoModel establecimiento) {
        this.establecimiento = establecimiento;
    }

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

    public CLienteModel getCliente() {
        return cliente;
    }

    public void setCliente(CLienteModel cliente) {
        this.cliente = cliente;
    }
}
