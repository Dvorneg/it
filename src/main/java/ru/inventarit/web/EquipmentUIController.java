package ru.inventarit.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inventarit.service.EquipmentService;


@Controller
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = EquipmentUIController.URL)
public class EquipmentUIController {
    static final String URL = "/profile/equipment";

    //@Autowired
    EquipmentService service;

    @GetMapping("")
    public String getAll() {
        log.info("EquipmentUIController");
        return "equipments";
    }

}
