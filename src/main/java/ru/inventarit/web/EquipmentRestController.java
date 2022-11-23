package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inventarit.model.Equipment;
import ru.inventarit.to.EquipmentTo;

import java.util.List;

@RestController
@RequestMapping(value = EquipmentRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class EquipmentRestController extends AbstractEquipmentController{
    static final String REST_URL = "/api/equipments";

    @GetMapping()
    public List<EquipmentTo> getAll() {
        log.info("getAll equipments");
        return super.getAll();
    }

    @GetMapping("/{id}")
    //public ResponseEntity<Equipment> get(@PathVariable int id) {
    public Equipment get(@PathVariable int id) {
        log.info("get equipment №{} ", id);
        return super.get(id);
    }

}
