package com.cgesgin.OtelTavsiye.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final int serialVersion=1;

    public ResourceNotFoundException(String massage) {
        super(massage);
    }

}