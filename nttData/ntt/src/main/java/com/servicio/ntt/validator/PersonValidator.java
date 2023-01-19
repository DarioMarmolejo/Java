package com.servicio.ntt.validator;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PersonValidator {
    
    public void validateExpressionAndThrowException (Boolean expression, RuntimeException exception ){
        if(expression.booleanValue()){
            throw exception;
        }
    }

    public void validDateInRange(Date date, Date initialDate, Date finalDate){

    }

    public void validRegularExpression(String value, String regularExpression){

    }

    public void validNumberInRange(BigDecimal value, BigDecimal floor, BigDecimal ceiling){
        
    }
}
