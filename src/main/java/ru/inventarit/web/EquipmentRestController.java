package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.inventarit.View;
import ru.inventarit.model.Equipment;
import ru.inventarit.to.EquipmentTo;

import java.net.URI;
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

    //@Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(View.Web.class) @RequestBody Equipment equipment, @PathVariable int id) {
        super.update(equipment);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipment> createWithLocation(@Validated(View.Web.class) @RequestBody Equipment equipment) {
        Equipment created = super.create(equipment);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
