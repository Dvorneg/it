package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inventarit.model.Equipment;


import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = EquipmentUIController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentUIController extends AbstractEquipmentController{
    static final String URL = "/profile/equipments";

    @GetMapping("")
    public List<Equipment> getAll() {
        log.info("EquipmentUIController getAll");
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrUpdate( Equipment equipment) {
        log.info("EquipmentUIController createOrUpdate");
        if (equipment.isNew()) {
            super.create(equipment);
        } else {
            super.update(equipment);
        }
    }

    @Override
    @GetMapping("/{id}")
    public Equipment get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }


    @GetMapping(   value = "/locale")
       public String getLocale() {
        log.info("locale страница");
        //model.addAttribute("TypeOfArray", getAllTypeOf());
        return LocaleContextHolder.getLocale().getLanguage();
        //return "ru";
    }

/*    public Equipment create(Equipment equipment) {
        log.info("create {}", equipment);
        //checkNew(equipment);
        return super.create(equipment);
    }*/

}
