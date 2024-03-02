package com.onlysystems.negocio.cliente.repository;

import com.onlysystems.negocio.cliente.entity.CLienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<CLienteModel, Integer> {
}
