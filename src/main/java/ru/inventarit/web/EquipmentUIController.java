package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.inventarit.View;
import ru.inventarit.model.Equipment;
import ru.inventarit.to.EquipmentTo;

import java.util.List;

@RestController //! Controller -
@Slf4j
@RequestMapping(value = EquipmentUIController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentUIController extends AbstractEquipmentController{
    static final String URL = "/profile/equipments";

    @GetMapping("")
    public List<EquipmentTo> getAll() {
        log.info("EquipmentUIController getAll");
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrUpdate(@Validated(View.Web.class) Equipment equipment) {
    //public void createOrUpdate(@Valid Equipment equipment, BindingResult bindingResult) {
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
        log.info("EquipmentUIController get id");
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

/*    public Equipment create(Equipment equipment) {
        log.info("create {}", equipment);
        //checkNew(equipment);
        return super.create(equipment);
    }*/

}
