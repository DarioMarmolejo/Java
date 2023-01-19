package com.servicio.ntt.validator;

import java.util.Arrays;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.constant.PersonConstants;
import com.servicio.ntt.exception.ServiceException;
import com.servicio.ntt.exception.custom.BadParametersException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ValidatorHelper {
    
    @Autowired
	private MessageSource messageSource;
	
	public <T> T validarCampo(String nombreCampo, T campo){
		log.debug(Constants.LOG_BEG);
		ifTrueThrowBadParametersException(campo==null, 
			Arrays.asList(nombreCampo).toArray(), 
			PersonConstants.MENSAJE_CAMPO_NULO);

		log.debug(Constants.LOG_END);
		return campo;
	}

	public String validarCampo(String nombreCampo, String campo){
		log.debug(Constants.LOG_BEG);

		ifTrueThrowBadParametersException(GenericValidator.isBlankOrNull(campo), 
			Arrays.asList(nombreCampo).toArray(), 
			PersonConstants.MENSAJE_CAMPO_NULO);
		
		log.debug(Constants.LOG_END);
		return campo.trim();
	}
	
	
	public String validarEmail(String email){
        log.debug(Constants.LOG_BEG);
		ifTrueThrowBadParametersException(!GenericValidator.isEmail(email.trim()), 
			Arrays.asList(email).toArray(), 
			PersonConstants.MENSAJE_EMAIL_NO_VALIDO);
        
        log.debug(Constants.LOG_END);
        return email.trim();
    }

	
	public static <T> T decidirValorObjeto(Boolean condicion, T valorA, T valorB) {
		
		if(condicion.booleanValue()) {
			return valorA;
		}
		
		return valorB;
	}

	public Boolean ifTrueThrow(Boolean condition, Object[] errFields ,String errCode){
		if(condition.booleanValue()){
			throw new ServiceException(
				messageSource.getMessage(errCode, 
				errFields, LocaleContextHolder.getLocale())
			);
		}else{
			return condition;
		}
	}

	public Boolean ifTrueThrowBadParametersException(Boolean condition, Object[] errFields ,String errCode){
		if(condition.booleanValue()){
			throw new BadParametersException(
				messageSource.getMessage(errCode, 
				errFields, LocaleContextHolder.getLocale())
			);
		}else{
			return condition;
		}
	}
}
