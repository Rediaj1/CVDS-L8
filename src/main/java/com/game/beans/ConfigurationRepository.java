package com.game.beans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationBean, Long>{
    boolean existsById(String propiedadId);
    ConfigurationBean findById(String propiedadId);
}