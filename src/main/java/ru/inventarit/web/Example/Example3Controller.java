package ru.inventarit.web.Example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.util.exception.Example.CustomException;
import ru.inventarit.util.exception.Example.Response;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// http://localhost:8081/testCustomExceptionResolver?exception=true

@RestController
public class Example3Controller {

    @GetMapping(value = "/testCustomExceptionResolver", produces = APPLICATION_JSON_VALUE)
    public Response testCustomExceptionResolver(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws CustomException {
        if (exception) {
            throw new CustomException("CustomException in testCustomExceptionResolver");
        }
        return new Response("OK");
    }


}