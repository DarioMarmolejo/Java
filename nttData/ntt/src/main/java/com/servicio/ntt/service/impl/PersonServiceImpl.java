package com.servicio.ntt.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.constant.PersonConstants;
import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.filter.Filter;
import com.servicio.ntt.model.filter.QueryOperator;
import com.servicio.ntt.model.repository.PersonRepository;
import com.servicio.ntt.model.request.CreatePersonRequest;
import com.servicio.ntt.model.request.PersonRequest;
import com.servicio.ntt.model.request.UpdatePersonRequest;
import com.servicio.ntt.model.specifications.SpecificationBuilder;
import com.servicio.ntt.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpecificationBuilder<PersonEntity> specificationBuilder;

    @Override
    public PersonEntity savePerson(PersonEntity createPersonEntity) {
        log.info(Constants.LOG_BEG);
        //validamos estatus
        createPersonEntity.setEstatus(true);

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
        personEntity.setPrimerNombre(updatePersonRequest.getPrimerNombre().toUpperCase());
        personEntity.setSegundoNombre(updatePersonRequest.getSegundoNombre().toUpperCase());
        personEntity.setPrimerApellido(updatePersonRequest.getPrimerApellido().toUpperCase());
        personEntity.setSegundoApellido(updatePersonRequest.getSegundoApellido().toUpperCase());
        personEntity.setEdad(updatePersonRequest.getEdad());
        personEntity.setEstadoCivil(updatePersonRequest.getEstadoCivil().toUpperCase());
        personEntity.setEmail(updatePersonRequest.getEmail().toLowerCase());
        personEntity.setTelefonoMovil(updatePersonRequest.getTelefonoMovil());
        personEntity.setTelefonoFijo(updatePersonRequest.getTelefonoFijo());
        personEntity.setFechaActualizacion(LocalDateTime.now());

        personRepository.save(personEntity);
        log.info(Constants.LOG_END);

        return personEntity;
    }

    @Override
    public Page<PersonEntity> recuperarUsuariosPorFiltrosAll(Pageable pageable, String codigoPersona,
            String estado,String estadoCivil) {
        log.info(Constants.LOG_BEG);
        Page<PersonEntity> personEntityPage = null;
        List<Filter> filters = new ArrayList<>();

        if (codigoPersona != null && !codigoPersona.isEmpty()) {
            Filter filtroCodigoPersona = Filter.builder().field(PersonConstants.CAMPO_CODIGO_PERSONA)
                    .operator(QueryOperator.LIKE).value(codigoPersona).build();
            filters.add(filtroCodigoPersona);
        }
        if (estado != null && !estado.isEmpty()) {
            Filter filtroEstado = Filter.builder().field(PersonConstants.CAMPO_ESTATUS)
                    .operator(QueryOperator.IN).value(estadoCivil).build();
            filters.add(filtroEstado);
        }
        if (estadoCivil != null && !estadoCivil.isEmpty()) {
            Filter filtroEstadoCivil = Filter.builder().field(PersonConstants.CAMPO_ESTADO_CIVIL)
                    .operator(QueryOperator.LIKE).value(estadoCivil).build();
            filters.add(filtroEstadoCivil);
        }
        log.info(specificationBuilder);
        personEntityPage = personRepository.findAll(specificationBuilder.getSpecificationFromFilters(filters),
                pageable);

        log.info(Constants.LOG_END);
        return personEntityPage;
    }

    @Override
    public Page<PersonEntity> recuperarUsuariosPorFiltros(Pageable pageable, String codigoPersona,
            String estadoCivil) {
        log.info(Constants.LOG_BEG);
        Page<PersonEntity> personEntityPage = null;
        List<Filter> filters = new ArrayList<>();

        if (codigoPersona != null && !codigoPersona.isEmpty()) {
            Filter filtroCodigoPersona = Filter.builder().field(PersonConstants.CAMPO_CODIGO_PERSONA)
                    .operator(QueryOperator.LIKE).value(codigoPersona).build();
            filters.add(filtroCodigoPersona);
        }
        if (estadoCivil != null && !estadoCivil.isEmpty()) {
            Filter filtroEstadoCivil = Filter.builder().field(PersonConstants.CAMPO_ESTADO_CIVIL)
                    .operator(QueryOperator.LIKE).value(estadoCivil).build();
            filters.add(filtroEstadoCivil);
        }
        log.info(specificationBuilder);
        personEntityPage = personRepository.findAll(specificationBuilder.getSpecificationFromFilters(filters),
                pageable);

        log.info(Constants.LOG_END);
        return personEntityPage;
    }

}
