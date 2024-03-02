package com.onlysystems.negocio.fiao.repository;

import com.onlysystems.negocio.cuenta.entity.CuentaModel;
import com.onlysystems.negocio.fiao.entity.FiaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FiaoRepository extends JpaRepository<FiaoModel, UUID> {

    List<FiaoModel> findByCuenta(CuentaModel cuenta);
}
