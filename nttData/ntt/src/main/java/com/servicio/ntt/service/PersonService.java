package com.servicio.ntt.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.request.UpdatePersonRequest;

public interface PersonService {

    PersonEntity savePerson(PersonEntity personEntity);

    public Page<PersonEntity> getAllPerson(Integer page, Integer size, Boolean enablePagination);

    public void deletePerson(String id);

    public Optional<PersonEntity> findById(String codigoPersona);

    public PersonEntity editPerson(PersonEntity personEntity, UpdatePersonRequest updatePersonRequest);

    public Page<PersonEntity> recuperarUsuariosPorFiltros(Pageable pageable, String codigoPersona, String estatus, String estadoCivil);
}
