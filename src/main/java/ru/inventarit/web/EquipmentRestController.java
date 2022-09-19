package ru.inventarit.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.model.Equipment;
import ru.inventarit.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping(value = EquipmentRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class EquipmentRestController {
    static final String REST_URL = "/api/equipments";

    private final EquipmentService service;

    @GetMapping()
    public List<Equipment> getAll() {
        log.info("getAll equipments");
        return service.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Equipment> get(@PathVariable int id) {
        log.info("get equipment №{} ", id);
        return service.getById(id);
    }

}
