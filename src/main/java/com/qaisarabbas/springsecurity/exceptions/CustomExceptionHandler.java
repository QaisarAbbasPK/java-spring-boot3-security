package com.qaisarabbas.springsecurity.exceptions;

/*
 * @created 27/08/2023 - 9:37 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.exceptions
 * @author Qaisar Abbas
 */

import com.qaisarabbas.springsecurity.models.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleInvalidArgument(MethodArgumentNotValidException exception) {
//        Map<String,String>errorMap = new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(error-> {
//            errorMap.put(error.getField(),error.getDefaultMessage());
//        });
        return new ApiResponse(
                "400",
                exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage(),
                null
        );
    }

    @ResponseStatus(HttpStatus.FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ApiResponse handleUserNotFoundException(UsernameNotFoundException exception) {
        return new ApiResponse("400", exception.getMessage(), null);

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(GlobalException.class)
    public ApiResponse handleGlobalException(GlobalException exception) {
        return new ApiResponse("400", exception.getMessage(), null);
    }
}
