package com.codigo.hibernate_persistencia.dao;

import com.codigo.hibernate_persistencia.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<BlogEntity,Long> {

}
