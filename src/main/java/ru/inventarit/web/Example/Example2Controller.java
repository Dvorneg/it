package ru.inventarit.web.Example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.util.exception.Example.Response;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


// http://localhost:8081//testResponseStatusExceptionResolver?exception=true

@RestController
public class Example2Controller {

    @GetMapping(value = "/testResponseStatusExceptionResolver", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusExceptionResolver(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws ServiceException {
        if (exception) {
            throw new ServiceException("ServiceException in testResponseStatusExceptionResolver");
        }
        return new Response("OK");
    }

    //INTERNAL_SERVER_ERROR  status=500
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) //NOT_FOUND 404
    public class ServiceException extends Exception {

        public ServiceException(String message) {
            super(message);
        }

    }



}
