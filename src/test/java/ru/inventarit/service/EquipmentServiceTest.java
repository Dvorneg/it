package ru.inventarit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import static ru.inventarit.EquipmentTestData.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import ru.inventarit.TimingExtension;
import ru.inventarit.model.Equipment;
import ru.inventarit.util.exception.NotFoundException;


@ActiveProfiles("test")
@SpringBootTest
@Transactional
//@Sql(scripts = "classpath:data.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ExtendWith(TimingExtension.class)
public class EquipmentServiceTest {

    @Autowired
    protected EquipmentService service;


    @Test
    void getAll() {
        EQUIPMENT_MATCHER.assertMatch(service.getAll(), equipments);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getByAdminId() {
        Equipment actual = service.getById(ADMIN_EQUIPMENT_ID);
        EQUIPMENT_MATCHER.assertMatch(actual,adminEquipment);
    }

    @Test
    @WithMockUser(username = "123@mail.ru", password = "123", roles = "USER")
    void create() {
        Equipment created = service.create(getNew());
        int newId = created.id();
        Equipment newMeal = getNew();
        newMeal.setId(newId);
        EQUIPMENT_MATCHER.assertMatch(created, newMeal);
        EQUIPMENT_MATCHER.assertMatch(service.getById(newId), newMeal);
    }

    @Test
    void update() {
        Equipment updated = getUpdated();
        service.update(updated);
        EQUIPMENT_MATCHER.assertMatch(service.getById(EQUIPMENT_ID), getUpdated());
    }

/*    @Test
    void delete() {
        service.delete(EQUIPMENT_ID);
        assertThrows(NotFoundException.class, () -> service.getById(EQUIPMENT_ID));
    }*/
}
