package ru.inventarit.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.inventarit.web.EquipmentController.REST_URL;
import static ru.inventarit.web.EquipmentTestData.EQUIPMENT_MATCHER;
import static ru.inventarit.web.EquipmentTestData.equipments;

public class EquipmentControllerTest extends AbstractControllerTest{

    @Test
    //@WithUserDetails(value = USER_MAIL)
    void getAllIsOk() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk());
    }

    @Test
        //@WithUserDetails(value = USER_MAIL)
    void getAllWithMatcher() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.person.name").value("Jason"));
                .andExpect(EQUIPMENT_MATCHER.contentJson (equipments));
    }

}
