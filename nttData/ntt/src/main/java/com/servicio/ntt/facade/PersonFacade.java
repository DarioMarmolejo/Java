package com.servicio.ntt.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.constant.PersonConstants;
import com.servicio.ntt.exception.ServiceException;
import com.servicio.ntt.exception.custom.NoDataFoundException;
import com.servicio.ntt.mapper.PersonMapper;
import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.request.CreatePersonRequest;
import com.servicio.ntt.model.request.UpdatePersonRequest;
import com.servicio.ntt.model.response.PersonResponse;
import com.servicio.ntt.model.response.ConsultarPersonResponse;
import com.servicio.ntt.model.response.EditPersonResponse;
import com.servicio.ntt.service.PersonService;

import lombok.extern.log4j.Log4j2;

/*
 * Capa Facade para validaciones y mapeos.
 */
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

        log.info(createPersonRequest);
        // Validamos que el request no sea nulo o este vacio
        if (createPersonRequest.getPrimerNombre() == null || createPersonRequest.getPrimerNombre().isEmpty()) {
            throw new NoDataFoundException(PersonConstants.BAD_REQUEST_EXCEPTION_VALIDATE);
        }
        if (createPersonRequest.getPrimerApellido() == null || createPersonRequest.getPrimerApellido().isEmpty()) {
            throw new NoDataFoundException(PersonConstants.BAD_REQUEST_EXCEPTION_VALIDATE);
        }
        if (createPersonRequest.getEdad() == null) {
            throw new NoDataFoundException(PersonConstants.BAD_REQUEST_EXCEPTION_VALIDATE);
        }
        if (createPersonRequest.getEstadoCivil() == null || createPersonRequest.getEstadoCivil().isEmpty()) {
            throw new NoDataFoundException(PersonConstants.BAD_REQUEST_EXCEPTION_VALIDATE);
        }
        if (createPersonRequest.getEmail() == null || createPersonRequest.getEmail().isEmpty()) {
            throw new NoDataFoundException(PersonConstants.BAD_REQUEST_EXCEPTION_VALIDATE);
        }
        // Validacion de campos
        if (createPersonRequest.getEstadoCivil().equals("soltero")
                || createPersonRequest.getEstadoCivil().equals("casado")
                || createPersonRequest.getEstadoCivil().equals("divorciado")
                || createPersonRequest.getEstadoCivil().equals("viudo")
                || createPersonRequest.getEstadoCivil().equals("concubinato")) {
                String estadoCivilLower=   createPersonRequest.getEstadoCivil();
                createPersonRequest.setEstadoCivil(estadoCivilLower.toUpperCase());
        }else{
            throw new NoDataFoundException(PersonConstants.PARAMETRO_ESTATUS_ERROR);
        }
        if (createPersonRequest.getEdad() < 1) {
            throw new NoDataFoundException(PersonConstants.ERRCODE_AGEMIN_NULL);
        } else if (createPersonRequest.getEdad() > 99) {
            throw new NoDataFoundException(PersonConstants.ERRCODE_AGEMIN_NULL);
        }
        log.info(createPersonRequest);

        
        personEntity= personService.savePerson(createEntity(createPersonRequest));
        response = PersonResponse.builder().codigoPersona(personEntity.getCodigoPersona()).build();

        log.info(Constants.LOG_END);
        return response;
    }

    public EditPersonResponse editPerson(String codigoPersona, UpdatePersonRequest updatePersonRequest) {
        log.info(Constants.LOG_BEG);
        EditPersonResponse totalPersonResponse = null;
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
        // Validations

        Optional<PersonEntity> optionalEntity = personService.findById(codigoPersona);
        personEntityEdit = optionalEntity.get();

        personEntityResponse = personService.editPerson(personEntityEdit, updatePersonRequest);

        totalPersonResponse = EditPersonResponse.builder()
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
    
    public ConsultarPersonResponse findWithFiltersAll(String codigoPersona, String estado,String estadoCivil,
            Integer pagina, Integer registros, String columna, String orden) {
        log.info(Constants.LOG_BEG);
        ConsultarPersonResponse consultarPersonResponse = null;
        Pageable pageable = null;
        Sort sortOrder = null;
        // Validacion Ordenamiendo Asc o Desc
        if (orden != null) {
            orden = orden.toUpperCase();
        } else {
            orden = PersonConstants.SORT_ASC;
        }

        if (columna == null) {
            columna = PersonConstants.CAMPO_CODIGO_PERSONA;
        }
        log.info(orden);
        // Validacion de orden y columna
        if (orden != PersonConstants.SORT_ASC || orden != PersonConstants.SORT_DESC) {
            /*
             * throw new
             * ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
             * new String[] { PersonConstants.PARAMETRO_ORDEN_ERROR },
             * LocaleContextHolder.getLocale()),
             * HttpStatus.BAD_REQUEST);
             */
        }
        if (columna != PersonConstants.CAMPO_CODIGO_PERSONA || columna != PersonConstants.CAMPO_ESTATUS
                || columna != PersonConstants.CAMPO_ESTADO_CIVIL) {
            /*
             * throw new
             * ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
             * new String[] { PersonConstants.PARAMETRO_ORDEN_ERROR },
             * LocaleContextHolder.getLocale()),
             * HttpStatus.BAD_REQUEST);
             */
        }

        // Se define Ordenamiento
        sortOrder = Sort.by(columna);

        switch (orden) {
            case "ASC":
                sortOrder = sortOrder.ascending();
                break;
            case "DESC":
                sortOrder = sortOrder.descending();
                break;
            default:
                sortOrder = sortOrder.descending();
                break;
        }

        // Ajuste a numero de página
        pagina = (pagina <= 0) ? 1 : pagina;

        // se llena el objeto pageable
        pageable = PageRequest.of(pagina - 1, registros, sortOrder);
        Page<PersonEntity> pagePersonEntity = personService.recuperarUsuariosPorFiltrosAll(pageable, codigoPersona,
                estado, estadoCivil);
        List<EditPersonResponse> personResponse = new ArrayList<>();
        for (PersonEntity personEntity : pagePersonEntity.getContent()) {
            EditPersonResponse personResponses = EditPersonResponse.builder()
                    .codigoPersona(personEntity.getCodigoPersona())
                    .estadoCivil(personEntity.getEstadoCivil())
                    .estatus(personEntity.isEstatus())
                    .build();
            personResponse.add(personResponses);
        }

        consultarPersonResponse = new ConsultarPersonResponse();
        consultarPersonResponse.setPersonas(personResponse);
        consultarPersonResponse.setPagina(pagePersonEntity.getNumberOfElements() == 0 ? 0 : pagina);
        consultarPersonResponse.setTotalPaginas(pagePersonEntity.getTotalPages());
        consultarPersonResponse.setRegistrosPorPagina(pagePersonEntity.getNumberOfElements());
        consultarPersonResponse.setTotalRegistros((int) pagePersonEntity.getTotalElements());

        log.info(Constants.LOG_END);
        return consultarPersonResponse;
    }

    public ConsultarPersonResponse findWithFilters(String codigoPersona, String estadoCivil,
            Integer pagina, Integer registros, String columna, String orden) {
        log.info(Constants.LOG_BEG);
        ConsultarPersonResponse consultarPersonResponse = null;
        Pageable pageable = null;
        Sort sortOrder = null;
        // Validacion Ordenamiendo Asc o Desc
        if (orden != null) {
            orden = orden.toUpperCase();
        } else {
            orden = PersonConstants.SORT_ASC;
        }

        if (columna == null) {
            columna = PersonConstants.CAMPO_CODIGO_PERSONA;
        }
        log.info(orden);
        // Validacion de orden y columna
        if (orden != PersonConstants.SORT_ASC || orden != PersonConstants.SORT_DESC) {
            /*
             * throw new
             * ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
             * new String[] { PersonConstants.PARAMETRO_ORDEN_ERROR },
             * LocaleContextHolder.getLocale()),
             * HttpStatus.BAD_REQUEST);
             */
        }
        if (columna != PersonConstants.CAMPO_CODIGO_PERSONA || columna != PersonConstants.CAMPO_ESTATUS
                || columna != PersonConstants.CAMPO_ESTADO_CIVIL) {
            /*
             * throw new
             * ServiceException(messageSource.getMessage(PersonConstants.ERRCODE_FIELD_NULL,
             * new String[] { PersonConstants.PARAMETRO_ORDEN_ERROR },
             * LocaleContextHolder.getLocale()),
             * HttpStatus.BAD_REQUEST);
             */
        }

        // Se define Ordenamiento
        sortOrder = Sort.by(columna);

        switch (orden) {
            case "ASC":
                sortOrder = sortOrder.ascending();
                break;
            case "DESC":
                sortOrder = sortOrder.descending();
                break;
            default:
                sortOrder = sortOrder.descending();
                break;
        }

        // Ajuste a numero de página
        pagina = (pagina <= 0) ? 1 : pagina;

        // se llena el objeto pageable
        pageable = PageRequest.of(pagina - 1, registros, sortOrder);
        Page<PersonEntity> pagePersonEntity = personService.recuperarUsuariosPorFiltros(pageable, codigoPersona,
                estadoCivil);
        List<EditPersonResponse> personResponse = new ArrayList<>();
        for (PersonEntity personEntity : pagePersonEntity.getContent()) {
            EditPersonResponse personResponses = EditPersonResponse.builder()
                    .codigoPersona(personEntity.getCodigoPersona())
                    .estadoCivil(personEntity.getEstadoCivil())
                    .estatus(personEntity.isEstatus())
                    .build();
            personResponse.add(personResponses);
        }

        consultarPersonResponse = new ConsultarPersonResponse();
        consultarPersonResponse.setPersonas(personResponse);
        consultarPersonResponse.setPagina(pagePersonEntity.getNumberOfElements() == 0 ? 0 : pagina);
        consultarPersonResponse.setTotalPaginas(pagePersonEntity.getTotalPages());
        consultarPersonResponse.setRegistrosPorPagina(pagePersonEntity.getNumberOfElements());
        consultarPersonResponse.setTotalRegistros((int) pagePersonEntity.getTotalElements());

        log.info(Constants.LOG_END);
        return consultarPersonResponse;
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

    public String stringIsEqualNull(String valueString) {
        if (valueString.equals("string")) {
            valueString = null;
        }
        return valueString;
    }

    public PersonEntity createEntity(CreatePersonRequest createPersonRequest) {
        PersonEntity personEntity = null;
        personEntity = PersonEntity.builder().primerNombre(createPersonRequest.getPrimerNombre())
                .primerApellido(createPersonRequest.getPrimerApellido())
                .edad(createPersonRequest.getEdad())
                .estadoCivil(createPersonRequest.getEstadoCivil())
                .email(createPersonRequest.getEmail())
                .build();
        return personEntity;
    }

}
