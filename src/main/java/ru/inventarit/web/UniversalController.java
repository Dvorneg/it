package ru.inventarit.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@Slf4j
public class UniversalController {

    @GetMapping(   value = "/locale")
    public String getLocale() {
        log.info("locale страница");
        //model.addAttribute("TypeOfArray", getAllTypeOf());
        return LocaleContextHolder.getLocale().getLanguage();
        //return "ru";
    }
}
