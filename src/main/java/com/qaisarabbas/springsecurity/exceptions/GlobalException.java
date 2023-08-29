package com.qaisarabbas.springsecurity.exceptions;

/*
 * @created 27/08/2023 - 9:48 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.exceptions
 * @author Qaisar Abbas
 */

public class GlobalException extends RuntimeException{
    public GlobalException(String message){
        super(message);
    }
}
