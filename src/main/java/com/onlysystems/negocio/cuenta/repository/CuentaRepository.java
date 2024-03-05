package com.onlysystems.negocio.cuenta.repository;

import com.onlysystems.negocio.cliente.entity.CLienteModel;
import com.onlysystems.negocio.cuenta.entity.CuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CuentaRepository extends JpaRepository<CuentaModel, UUID> {

    List<CuentaModel> findByCliente(CLienteModel cliente);

}
