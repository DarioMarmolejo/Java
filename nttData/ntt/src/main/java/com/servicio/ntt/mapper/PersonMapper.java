package com.servicio.ntt.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;

import com.servicio.ntt.model.entity.PersonEntity;
import com.servicio.ntt.model.request.CreatePersonRequest;
import com.servicio.ntt.model.request.PersonRequest;
import com.servicio.ntt.model.request.UpdatePersonRequest;
import com.servicio.ntt.model.response.EditPersonResponse;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    
    
    public abstract PersonEntity requestToEntityforCreate(CreatePersonRequest createPersonRequest);

    public abstract PersonEntity idRequestToEntity(PersonRequest personRequest);

    public abstract PersonEntity requestToEntityforUpdate(UpdatePersonRequest updatePersonRequest);

    public EditPersonResponse entityToResponse(Optional<PersonEntity> personEntity);


}
