package com.ias.testTecnico.domain.model.tickets.util;

import com.ias.testTecnico.domain.model.exceptions.BusinessExceptions;
import lombok.Getter;

@Getter
public class Travel {

    private String travel;

    public Travel(String travel) {
        if (travel == null || travel.isEmpty()){
            throw new BusinessExceptions("Id travel is required");
        }else{
            this.travel = travel;
        }
    }

}
