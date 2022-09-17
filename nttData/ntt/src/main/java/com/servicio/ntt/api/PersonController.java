package com.servicio.ntt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
import com.servicio.ntt.model.response.ActualizaPersonResponse;
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
    
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonResponse> savePerson(@RequestBody CreatePersonRequest createPersonRequest){
        log.info(Constants.LOG_BEG);
        ResponseEntity<PersonResponse> response = null;
        PersonResponse personResponse = personFacade.create(createPersonRequest);
        response = new ResponseEntity<>(personResponse, HttpStatus.CREATED);
        log.info(Constants.LOG_END);
        return response;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<PersonEntity>> getAllPerson(
        @RequestParam(required = false, defaultValue = "0")Integer page,
        @RequestParam(required = false, defaultValue = "10")Integer size,
        @RequestParam(required = false, defaultValue = "false")Boolean enablePagination){
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return ResponseEntity.ok(personServiceImpl.getAllPerson(page, size, enablePagination));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<PersonResponse> deletePerson(@RequestParam(required = true,name = "codigoPersona")String codigoPersona){
        log.info(Constants.LOG_BEG);
        ResponseEntity<PersonResponse> responses = null;
        PersonResponse responseResult = personFacade.deletePerson(codigoPersona);
        responses = new ResponseEntity<>(responseResult, HttpStatus.OK);
        log.info(Constants.LOG_END);
        return responses;
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<ActualizaPersonResponse> editPerson(@RequestParam(required = true, name = "codigoPersona") String codigoPersona,@RequestBody UpdatePersonRequest updatePersonRequest){
        log.info(Constants.LOG_BEG);
        ResponseEntity<ActualizaPersonResponse> totalResponse = null;
        ActualizaPersonResponse totalPersonResponse= personFacade.editPerson(codigoPersona,updatePersonRequest);
        totalResponse =new ResponseEntity<>(totalPersonResponse, HttpStatus.OK);
        log.info(Constants.LOG_END);
        return totalResponse;
    }

    @GetMapping(value = "/findByStatus")
    public ResponseEntity<PersonRequest> findByfindByStatus(){
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return null;
    }

    @GetMapping(value = "/findByCodigoPersona")
    public ResponseEntity<PersonRequest> findByCodigoPersona(@RequestBody(required = true) PersonRequest personRequest){
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return null;
    }

    @GetMapping(value = "/findByEstadoCivil")
    public ResponseEntity<PersonRequest> findByEstadoCivil(){
        log.info(Constants.LOG_BEG);
        log.info(Constants.LOG_END);
        return null;
    }
    
}
