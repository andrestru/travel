package com.ias.testTecnico.infrastructure.entrypoints.util;

import com.ias.testTecnico.domain.model.searchTravel.TravelEntity;
import com.ias.testTecnico.domain.model.exceptions.BusinessExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CreateExceptions {

    @ExceptionHandler(BusinessExceptions.class)
    public ResponseEntity<TravelEntity> exception(BusinessExceptions e){
        TravelEntity entity = new TravelEntity(null, "FAILED", e.getMessage());
        return ResponseEntity.badRequest().body(entity);
    }

}
