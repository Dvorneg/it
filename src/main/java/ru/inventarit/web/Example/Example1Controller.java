package ru.inventarit.web.Example;

import org.springframework.web.bind.annotation.*;
import ru.inventarit.util.exception.Example.BusinessException;
import ru.inventarit.util.exception.Example.Response;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//   http://localhost:8081/testExceptionHandler?exception=true
// http://localhost:8081/testExceptionHandler?exception=false

@RestController
public class Example1Controller {

    @GetMapping(value = "/testExceptionHandler", produces = APPLICATION_JSON_VALUE)
    //@ResponseBody
    public Response testExceptionHandler(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in testExceptionHandler");
        }
        return new Response("OK");
    }

    @ExceptionHandler(BusinessException.class)
    public Response handleException(BusinessException e) {
        return new Response(e.getMessage());
    }

}