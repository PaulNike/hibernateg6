package com.codigo.hibernate_persistencia.dao;

import com.codigo.hibernate_persistencia.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
