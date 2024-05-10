package com.ias.testTecnico.domain.model.tickets.util;

import com.ias.testTecnico.domain.model.exceptions.BusinessExceptions;
import lombok.Getter;

@Getter
public class Document {

    private String document;

    public Document(String document) {
        if (document == null || document.isEmpty()){
            throw new BusinessExceptions("Document is required");
        }else{
            this.document = document;
        }
    }

}
