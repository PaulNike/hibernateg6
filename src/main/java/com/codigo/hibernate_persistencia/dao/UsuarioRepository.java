package com.codigo.hibernate_persistencia.dao;

import com.codigo.hibernate_persistencia.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


}

