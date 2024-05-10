package com.ias.testTecnico.domain.model.tickets.util;

import com.ias.testTecnico.domain.model.exceptions.BusinessExceptions;
import com.ias.testTecnico.domain.model.exceptions.Validations;
import lombok.Getter;

@Getter
public class Name {

    private String name;

    public Name(String name) {
        if (name == null || name.isEmpty()){
            throw new BusinessExceptions("Name is required");
        }else if(Validations.validateSize(name)){
            throw new BusinessExceptions("Name must have a maximum of 30 characters");
        }else if(!Validations.validateString(name)){
            throw new BusinessExceptions("Name must have only letters");
        }else{
            this.name = name;
        }
    }

}
