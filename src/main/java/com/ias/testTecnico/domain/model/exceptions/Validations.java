package com.ias.testTecnico.domain.model.exceptions;

public class Validations {

    public static boolean validateSize(String value){
        if (value.length() > 30){
            return true;
        }
        return false;
    }


    public static boolean validateString(String value){
        String regex = "[a-zA-Z]+";
        if (value.matches(regex)){
            return true;
        }
        return false;
    }


}
