package com.onlysystems.negocio.usuario.repository;

import com.onlysystems.negocio.usuario.entity.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
}
