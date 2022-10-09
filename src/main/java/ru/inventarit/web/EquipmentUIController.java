package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
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
            //update(equipment, equipment.getId());
        }
    }

/*    public Equipment create(Equipment equipment) {
        log.info("create {}", equipment);
        //checkNew(equipment);
        return super.create(equipment);
    }*/

}
