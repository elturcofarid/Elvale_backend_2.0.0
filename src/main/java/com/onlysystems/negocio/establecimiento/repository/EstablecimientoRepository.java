package com.onlysystems.negocio.establecimiento.repository;

import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablecimientoRepository extends JpaRepository<EstablecimientoModel, Integer> {
}
