package com.codigo.hibernate_persistencia.dao;

import com.codigo.hibernate_persistencia.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {

    Optional<List<PersonaEntity>> findByEstado(Integer estado);
    boolean existsById(Long id);

}
