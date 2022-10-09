package ru.inventarit.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.inventarit.model.Equipment;
import ru.inventarit.service.EquipmentService;

import java.util.List;

@Slf4j
public abstract class AbstractEquipmentController {
    @Autowired
    private EquipmentService service;

    public Equipment get(int id) {
        //int userId = SecurityUtil.authUserId();
        log.info("get equipment {} ", id);
        return service.getById(id);
    }

/*    public void delete(int id) {
        //int userId = SecurityUtil.authUserId();
        log.info("delete equipment {} ", id);
        service.delete(id);
    }*/

    public List<Equipment> getAll() {
        //int userId = SecurityUtil.authUserId();
        log.info("getAll ");
        return service.getAll();
    }

    public Equipment create(Equipment equipment) {
        //int userId = SecurityUtil.authUserId();
        log.info("create ", equipment);
        //checkNew(equipment);
        return service.create(equipment);
    }

/*    public void update(Equipment equipment, int id) {
        //int userId = SecurityUtil.authUserId();
        log.info("update {} ", equipment);
        //assureIdConsistent(equipment, id);
        service.update(equipment);
    }*/


}
