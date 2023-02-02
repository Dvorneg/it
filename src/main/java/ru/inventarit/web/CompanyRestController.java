package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.inventarit.model.Company;
import ru.inventarit.service.CompanyService;
import ru.inventarit.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/profile/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyRestController {

    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public CompanyRestController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping("")
    public List<Company> getUserCompany(@AuthenticationPrincipal AuthUser authUser) {
        log.info("getUserCompany {}", authUser);
        return userService.getUserCompany(authUser.getId());
    }

    @PostMapping("/{nameCompany}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void AddCompany(@AuthenticationPrincipal AuthUser authUser, @PathVariable String nameCompany) {
        //check
        Company company = new Company( nameCompany);
        //return companyService.create(company);
        companyService.create(company, authUser.getId());

    }



}
