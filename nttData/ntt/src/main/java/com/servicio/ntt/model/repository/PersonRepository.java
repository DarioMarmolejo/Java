package com.servicio.ntt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.servicio.ntt.model.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String>, JpaSpecificationExecutor<PersonEntity>{
    
    public PersonEntity findByCodigoPersona(String codigoPersona);
}
