package ru.inventarit.web.Example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.util.exception.Example.BusinessException;
import ru.inventarit.util.exception.Example.Response;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


// http://localhost:8081/testDefaultControllerAdvice?exception=true


@RestController
@CustomExceptionHandler
public class Example5Controller {

    @GetMapping(value = "/testCustomControllerAdvice", produces = APPLICATION_JSON_VALUE)
    public Response testCustomControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in testCustomControllerAdvice");
        }
        return new Response("OK");
    }

}
