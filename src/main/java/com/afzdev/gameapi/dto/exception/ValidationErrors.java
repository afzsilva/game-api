package com.afzdev.gameapi.dto.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends  ErrorResponse{

    private List<FieldError> fieldErrors = new ArrayList<>();

    public ValidationErrors(Instant timeStamp, Integer httpStatus, String message, String exception, String path) {
        super(timeStamp, httpStatus, message, exception, path);
    }


    public List<FieldError> getErrors(){
        return fieldErrors;
    }

    public void addError(String fieldName, String message){
        fieldErrors.add(new FieldError(fieldName,message));
    }

}
