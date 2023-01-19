package com.servicio.ntt.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.facade.PersonFacade;
import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.request.CreatePersonRequest;
import com.servicio.ntt.model.request.PersonRequest;
import com.servicio.ntt.model.request.UpdatePersonRequest;
import com.servicio.ntt.model.response.PersonResponse;
import com.servicio.ntt.model.response.ConsultarPersonResponse;
import com.servicio.ntt.model.response.EditPersonResponse;
import com.servicio.ntt.service.impl.PersonServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonFacade personFacade;

    @Autowired
    private PersonServiceImpl personServiceImpl;

    /**
     * @description Metodo para creear el registro de una persona.
     *
     * @author Dario Marmolejo
     * @version 1.0.0, 14/09/2022
     * @param primerNombre   -> Primer nombre de la persona
     * @param primerApellido -> apellido Paterno de la persona
     * @param edad           -> edad mayor a 9 y menor a 99
     * @param estadoCivil    -> estado civil de la persona(soltero,casado,
     *                       divorciado, separación en proceso judicial, viudo y
     *                       concubinato)
     * @param email          -> contacto del usuario
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonResponse> savePerson( @RequestBody CreatePersonRequest createPersonRequest) {
        log.info(Constants.LOG_BEG);
        ResponseEntity<PersonResponse> response = null;
        PersonResponse personResponse = personFacade.create(createPersonRequest);
        response = new ResponseEntity<>(personResponse, HttpStatus.CREATED);
        log.info(Constants.LOG_END);
        return response;
    }

    /**
     * @description Metodo para obtener los registros
     *
     * @author Dario Marmolejo
     * @version 1.0.0, 14/09/2022
     * @param pagina           -> parámetro para el número de página
     * @param registros        -> parámetro para el número de registros
     * @param enablePagination ->
     */
    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<PersonEntity>> getAllPerson(
            @RequestParam(required = false, defaultValue = "0") Integer pagina,
            @RequestParam(required = false, defaultValue = "10") Integer registros,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return ResponseEntity.ok(personServiceImpl.getAllPerson(pagina, registros, enablePagination));
    }

    /**
     * @description Metodo para eliminar un registro de una persona.
     *
     * @author Dario Marmolejo
     * @version 1.0.0, 14/09/2022
     * @param codigoPersona -> Identificador para busqueda de la persona
     * 
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<PersonResponse> deletePerson(
            @RequestParam(required = true, name = "codigoPersona") String codigoPersona) {
        log.info(Constants.LOG_BEG);
        ResponseEntity<PersonResponse> responses = null;
        PersonResponse responseResult = personFacade.deletePerson(codigoPersona);
        responses = new ResponseEntity<>(responseResult, HttpStatus.OK);
        log.info(Constants.LOG_END);
        return responses;
    }

    /**
     * @description Metodo para editar el registro de una persona.
     *
     * @author Dario Marmolejo
     * @version 1.0.0, 14/09/2022
     * @param primerNombre   ->
     * @param primerApellido ->
     * @param edad           ->
     * @param estadoCivil    ->
     * @param email          -> contacto del usuario
     */
    @PutMapping(value = "/edit")
    public ResponseEntity<EditPersonResponse> editPerson(
            @RequestParam(required = true, name = "codigoPersona") String codigoPersona,
            @RequestBody UpdatePersonRequest updatePersonRequest) {
        log.info(Constants.LOG_BEG);
        ResponseEntity<EditPersonResponse> totalResponse = null;
        EditPersonResponse totalPersonResponse = personFacade.editPerson(codigoPersona, updatePersonRequest);
        totalResponse = new ResponseEntity<>(totalPersonResponse, HttpStatus.OK);
        log.info(Constants.LOG_END);
        return totalResponse;
    }

    /**
     * @description Metodo para obtener las personas con estatus activas o inactivas
     *
     * @author Dario Marmolejo
     * @version 1.0.0, 15/09/2022
     * @param estatus -> Identificador para busqueda por filtro.
     */
    @GetMapping(value = "/findWithFilters/estado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultarPersonResponse> findWithFiltersAll(
            @RequestParam(required = false, name = "codigoPersona") String codigoPersona,
            @RequestParam(required = false, name = "estado")String estado,
            @RequestParam(required = false, name = "estadoCivil") String estadoCivil,
            @RequestParam(required = false, name = "pagina") Integer pagina,
            @RequestParam(required = false, name = "registros") Integer registros,
            @RequestParam(required = false, name = "columna") String columna,
            @RequestParam(required = false, name = "orden") String orden) {
        log.info(Constants.LOG_BEG);

        ConsultarPersonResponse response = null;
        response = personFacade.findWithFiltersAll(codigoPersona, estadoCivil,estado, pagina, registros, columna, orden);
        ResponseEntity<ConsultarPersonResponse> result = new ResponseEntity<>(response, HttpStatus.OK);

        log.info(Constants.LOG_END);
        return result;
    }

    /**
     * @description Metodo para creear una busqueda por filtros de codigoPersona o
     *              EstadoCivil
     *
     * @author Dario Marmolejo
     * @version 1.0.0, 15/09/2022
     * @param codigoPersona filtro para el id de la persona
     * @param estatus       filtro para el estatus de cada persona
     * @param estadoCivil   filtro para el estado civil de cada persona
     * @param pagina        parámetro para el número de página
     * @param registros     parámetro para el número de registros
     * @param columna       parámetro para indicar la columna sobre la cual se
     *                      ordenarán los resultados
     * @param orden         parámetro para indicar si el orden es ascendente o
     *                      descendente
     * 
     */
    @GetMapping(value = "/findWithFilters", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultarPersonResponse> findWithFilters(
            @RequestParam(required = false, name = "codigoPersona") String codigoPersona,
            @RequestParam(required = false, name = "estadoCivil") String estadoCivil,
            @RequestParam(required = false, name = "pagina") Integer pagina,
            @RequestParam(required = false, name = "registros") Integer registros,
            @RequestParam(required = false, name = "columna") String columna,
            @RequestParam(required = false, name = "orden") String orden) {
        log.info(Constants.LOG_BEG);

        ConsultarPersonResponse response = null;
        response = personFacade.findWithFilters(codigoPersona, estadoCivil, pagina, registros, columna, orden);
        ResponseEntity<ConsultarPersonResponse> result = new ResponseEntity<>(response, HttpStatus.OK);

        log.info(Constants.LOG_END);
        return result;
    }
}
