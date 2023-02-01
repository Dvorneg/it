package ru.inventarit.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import ru.inventarit.model.Equipment;
import ru.inventarit.service.EquipmentService;
import ru.inventarit.to.EquipmentTo;
import ru.inventarit.util.EquipmentsUtil;
import ru.inventarit.util.SecurityUtil;

import java.util.List;

import static ru.inventarit.util.validation.ValidationUtil.checkNew;

@Slf4j
public abstract class AbstractEquipmentController {
    @Autowired
    private EquipmentService service;

    public Equipment get(int id) {
        //int userId = SecurityUtil.authUserId();
        log.info("get equipment {} ", id);
        return service.getById(id) ;
    }

    public void delete(int id) {
        //int userId = SecurityUtil.authUserId();
        log.info("delete equipment {} ", id);
        service.delete(id);
    }

    //Collection-> list
    public List<EquipmentTo> getAll() {
        int userId = SecurityUtil.authUserId();
        log.info("getAll ");
        return EquipmentsUtil.filterByPredicate(service.getAll(), LocaleContextHolder.getLocale().getLanguage());
        //return EquipmentsUtil.filterByPredicate(service.getAll(), LocaleContextHolder.getLocale().getLanguage());
    }

    public Equipment create(Equipment equipment) {
        //int userId = SecurityUtil.authUserId();
        log.info("create {}", equipment);
        checkNew(equipment);
        return service.create(equipment);
    }

    public void update(Equipment equipment) {
        //int userId = SecurityUtil.authUserId();
        log.info("update {} ", equipment);
        service.update(equipment);
    }


}
