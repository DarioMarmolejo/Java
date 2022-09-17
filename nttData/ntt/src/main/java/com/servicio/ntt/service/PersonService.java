package com.servicio.ntt.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.request.UpdatePersonRequest;

public interface PersonService {

    PersonEntity savePerson(PersonEntity personEntity);

    public Page<PersonEntity> getAllPerson(Integer page, Integer size, Boolean enablePagination);

    public void deletePerson(String id);

    public Optional<PersonEntity> findById(String codigoPersona);

    public PersonEntity editPerson(PersonEntity personEntity, UpdatePersonRequest updatePersonRequest);
}
