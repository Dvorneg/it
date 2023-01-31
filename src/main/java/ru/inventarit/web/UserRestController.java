package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.model.Company;
import ru.inventarit.service.UserService;

import java.util.List;

//УДАЛИТЬ
@Slf4j
@RestController
@RequestMapping(value="/profile/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    private final UserService service;

    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Company> getUserCompany(@AuthenticationPrincipal AuthUser authUser) {
        log.info("getUserCompany {}", authUser);
        return service.getUserCompany(authUser.getId());
    }

}
