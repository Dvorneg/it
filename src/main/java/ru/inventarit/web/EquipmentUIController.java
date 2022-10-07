package ru.inventarit.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inventarit.model.Equipment;
import ru.inventarit.service.EquipmentService;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = EquipmentUIController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentUIController {
    static final String URL = "/profile/equipments";

    @Autowired
    EquipmentService service;

    @GetMapping("")
    public List<Equipment> getAll() {
        log.info("EquipmentUIController getAll");
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrUpdate( Equipment equipment) {
        log.info("EquipmentUIController createOrUpdate");
        if (equipment.isNew()) {
            create(equipment);
        } else {
            //update(equipment, equipment.getId());
        }
    }

    public Equipment create(Equipment equipment) {
        log.info("create {}", equipment);
        //checkNew(equipment);
        return service.create(equipment);
    }

}
