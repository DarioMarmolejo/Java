package com.servicio.ntt.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.repository.PersonRepository;
import com.servicio.ntt.model.request.UpdatePersonRequest;
import com.servicio.ntt.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity savePerson(PersonEntity createPersonEntity) {
        log.info(Constants.LOG_BEG);
        //
        createPersonEntity.setEstatus(true);
        log.info("NO ES NULO STATUS DE SERVICE");
        if (createPersonEntity != null && createPersonEntity.getFechaCreacion() == null) {
            createPersonEntity.setFechaCreacion(LocalDateTime.now());
        }
        if (createPersonEntity != null && createPersonEntity.getFechaActualizacion() == null) {
            createPersonEntity.setFechaActualizacion(createPersonEntity.getFechaActualizacion());
        }

        personRepository.save(createPersonEntity);
        log.info(Constants.LOG_END);
        return createPersonEntity;
    }

    @Override
    public Page<PersonEntity> getAllPerson(Integer page, Integer size, Boolean enablePagination) {
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return personRepository.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
        
    }

    @Override
    public void deletePerson(String id) {
        log.info(Constants.LOG_BEG);
        personRepository.deleteById(id);
        log.info(Constants.LOG_END);
    }

    @Override
    public Optional<PersonEntity> findById(String codigoPersona) {
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return personRepository.findById(codigoPersona);
    }

    @Override
    public PersonEntity editPerson(PersonEntity personEntity, UpdatePersonRequest updatePersonRequest) {
        log.info(Constants.LOG_BEG);
        personEntity.setPrimerNombre(updatePersonRequest.getPrimerNombre());
        personEntity.setSegundoNombre(updatePersonRequest.getSegundoNombre());
        personEntity.setPrimerApellido(updatePersonRequest.getPrimerApellido());
        personEntity.setSegundoApellido(updatePersonRequest.getSegundoApellido());
        personEntity.setEdad(updatePersonRequest.getEdad());
        personEntity.setEstadoCivil(updatePersonRequest.getEstadoCivil());
        personEntity.setEmail(updatePersonRequest.getEmail());
        personEntity.setTelefonoMovil(updatePersonRequest.getTelefonoMovil());
        personEntity.setTelefonoFijo(updatePersonRequest.getTelefonoFijo());
        personEntity.setFechaActualizacion(LocalDateTime.now());

        personRepository.save(personEntity);
        log.info(Constants.LOG_END);

        return personEntity;
    }

}
