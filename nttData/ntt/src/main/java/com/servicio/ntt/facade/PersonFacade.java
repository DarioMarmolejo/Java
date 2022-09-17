package com.servicio.ntt.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.constant.PersonConstants;
import com.servicio.ntt.exception.ServiceException;
import com.servicio.ntt.mapper.PersonMapper;
import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.request.CreatePersonRequest;
import com.servicio.ntt.model.request.UpdatePersonRequest;
import com.servicio.ntt.model.response.PersonResponse;
import com.servicio.ntt.model.response.ActualizaPersonResponse;
import com.servicio.ntt.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonFacade {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private MessageSource messageSource;

    public PersonResponse create(CreatePersonRequest createPersonRequest) {
        log.info(Constants.LOG_BEG);

        PersonResponse response = null;
        PersonEntity personEntity = null;

        if (createPersonRequest.getPrimerNombre() == null || createPersonRequest.getPrimerNombre().isEmpty()) {
            throw new ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
                    new String[] { "PrimerNombre" }, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
        }
        if (createPersonRequest.getPrimerApellido() == null || createPersonRequest.getPrimerApellido().isEmpty()) {
            throw new ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
                    new String[] { "PrimerApellido" }, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
        }
        if (createPersonRequest.getEdad() == null || createPersonRequest.getEdad() < 1) {
            throw new ServiceException(
                    messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL, null, LocaleContextHolder.getLocale()),
                    HttpStatus.BAD_REQUEST);
        }
        if (createPersonRequest.getEdad() == null || createPersonRequest.getEdad() > 99) {
            throw new ServiceException(
                    messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL, null, LocaleContextHolder.getLocale()),
                    HttpStatus.BAD_REQUEST);
        }
        if (createPersonRequest.getEmail() == null || createPersonRequest.getEmail().isEmpty()) {
            throw new ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
                    new String[] { "EstadoCivil" }, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
        }

        personEntity = personMapper.requestToEntityforCreate(createPersonRequest);
        personService.savePerson(personEntity);
        response = PersonResponse.builder().codigoPersona(personEntity.getCodigoPersona()).build();

        log.info(Constants.LOG_END);
        return response;
    }

    public ActualizaPersonResponse editPerson(String codigoPersona, UpdatePersonRequest updatePersonRequest) {
        log.info(Constants.LOG_BEG);
        ActualizaPersonResponse totalPersonResponse = null;
        PersonEntity personEntityEdit = null;
        PersonEntity personEntityResponse = null;

        if (codigoPersona == null || codigoPersona.isEmpty()) {
            throw new ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
                    new String[] { "codigoPersona" }, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
        }
        if (updatePersonRequest == null) {
            throw new ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
                    new String[] { "updatePersonRequest" }, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
        }
        Optional<PersonEntity> optionalEntity = personService.findById(codigoPersona);
        personEntityEdit = optionalEntity.get();

        personEntityResponse = personService.editPerson(personEntityEdit, updatePersonRequest);

        totalPersonResponse = ActualizaPersonResponse.builder()
                .codigoPersona(personEntityResponse.getCodigoPersona())
                .primerNombre(personEntityResponse.getPrimerNombre())
                .segundoNombre(personEntityResponse.getSegundoNombre())
                .primerApellido(personEntityResponse.getPrimerApellido())
                .segundoApellido(personEntityResponse.getSegundoApellido())
                .edad(personEntityResponse.getEdad())
                .estadoCivil(personEntityResponse.getEstadoCivil())
                .email(personEntityResponse.getEmail())
                .telefonoMovil(personEntityResponse.getTelefonoMovil())
                .telefonoFijo(personEntityResponse.getTelefonoFijo())
                .fechaActualizacion(personEntityResponse.getFechaActualizacion())
                .build();
        log.info(totalPersonResponse);

        log.info(Constants.LOG_END);
        return totalPersonResponse;
    }

    public PersonResponse deletePerson(String id) {
        log.info(Constants.LOG_BEG);
        PersonResponse responseDelete = null;

        if (id == null || id.isEmpty()) {
            throw new ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
                    new String[] { "CodigoPersona" }, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
        }
        personService.deletePerson(id);
        responseDelete.builder().codigoPersona(id).build();
        log.info(Constants.LOG_END);
        return responseDelete;
    }
}
