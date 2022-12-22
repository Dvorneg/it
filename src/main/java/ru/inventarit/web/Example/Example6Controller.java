package ru.inventarit.web.Example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.inventarit.util.exception.Example.Response;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


// http://localhost:8081/testResponseStatusException?exception=true

@RestController
public class Example6Controller {

    @GetMapping(value = "/testResponseStatusException", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusException(@RequestParam(required = false, defaultValue = "false") boolean exception) {
        if (exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ResponseStatusException in testResponseStatusException");
        }
        return new Response("OK");
    }

}
