package ru.inventarit.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.model.Equipment;
import ru.inventarit.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping(value = EquipmentController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class EquipmentController {
    static final String REST_URL = "/api/equipments";

    private final EquipmentService service;

    @GetMapping()
    public List<Equipment> getAll() {
        log.info("getAll equipments");
        return service.getAll();
    }

}
