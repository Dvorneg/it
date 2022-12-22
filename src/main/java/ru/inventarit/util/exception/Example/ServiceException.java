package ru.inventarit.util.exception.Example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//INTERNAL_SERVER_ERROR  status=500
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) //NOT_FOUND 404
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

}
