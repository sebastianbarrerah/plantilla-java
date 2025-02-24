package com.buildingblocks.shared.domain.utils;

public class ValidateUtils {

    public static Object validateIsNotNull(Object object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);
        }
        return object;
    }

    public static Object validateIsNotEmpty(String string, String message){
        if(string == null || string.isEmpty()){
            throw new IllegalArgumentException(message);
        }
        return string;
    }

    public static Object validateIsNotBlank(String atributo, String message){
        if(atributo.isBlank()){
            throw new IllegalArgumentException(message);
        }
        return atributo;
    }


    public static int validateIsPositive(int number, String message){
        if(number < 0){
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public Object isValidEmail(String email) {
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return false;
        }
        return email;
    }

    public static Object validateMaxLength(String string, int maxLength, String message){
        if(string.length() > maxLength){
            throw new IllegalArgumentException(message);
        }
        return string;
    }

    public static Object validateIsString(String string, String message){
        if(string.matches("[0-9]")){
            throw new IllegalArgumentException(message);
        }
        return string;
    }

}