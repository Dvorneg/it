package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import static ru.inventarit.util.EquipmentsUtil.getAllTypeOf;

@Controller
@Slf4j
public class RootController {
    @GetMapping("/")
    public String index() {
        log.info("стартовая страница");
        return "index";
    }


    //https://stackoverflow.com/questions/15073830/spring-formoptions-tag-with-enum
    @GetMapping(   "/equipments")
    public String getEquipments(ModelMap model) {
        log.info("equipments страница");
        model.addAttribute("TypeOfArray", getAllTypeOf());
        return "equipments";
    }

}
