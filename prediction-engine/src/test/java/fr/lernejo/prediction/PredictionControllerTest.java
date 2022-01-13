package fr.lernejo.prediction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PredictionControllerTest {

    @Test
    void getTemp(@Autowired MockMvc mockMvc)throws Exception {

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/temperature?country=France"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getTempError(@Autowired MockMvc mockMvc)throws Exception {

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/temperature?country=Covid"))
            .andExpect(MockMvcResultMatchers.status().is(417));
    }
}
