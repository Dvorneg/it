package ru.inventarit.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.inventarit.EquipmentTestData.*;
import static ru.inventarit.util.EquipmentsUtil.getTos;
import static ru.inventarit.web.EquipmentRestController.REST_URL;

public class EquipmentRestControllerTest extends AbstractControllerTest{

    @Test
    @WithMockUser(roles = "USER")
    void getAllIsOk() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    void getAllWithMatcher() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))

                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(TO_MATCHER.contentJson ( getTos(equipments )));
    }


    @Test
    @WithMockUser(roles = "USER")
    void getAllWithMatcherElement() throws Exception {

        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(jsonPath("$[1].company").value("LG"));
    }


}
