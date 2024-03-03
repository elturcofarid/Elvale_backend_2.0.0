package com.onlysystems.negocio.establecimiento.repository;

import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstablecimientoRepository extends JpaRepository<EstablecimientoModel, UUID> {
}
