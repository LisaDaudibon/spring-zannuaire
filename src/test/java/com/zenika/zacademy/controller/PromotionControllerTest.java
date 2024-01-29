package com.zenika.zacademy.controller;

import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.service.PromotionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PromotionController.class)
public class PromotionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PromotionService promotionService;

    @Test
    public void testFindAll() throws Exception {

        ArrayList<Promotion> promotions = new ArrayList<>();
        // Mock data
        promotions.add(new Promotion(8, "javatars", LocalDate.of(2022,12,22), new HashSet<>(), new HashSet<>()));
        promotions.add(new Promotion(5, "javenturiers", LocalDate.of(2023, 4,5),new HashSet<>(), new HashSet<>()));

        // Mock the service behavior
        given(promotionService.findAll()).willReturn(promotions);

        ResultActions result = mockMvc.perform(get("/promotions")
                .contentType(MediaType.APPLICATION_JSON));

        // Perform the GET request
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(8))
                .andExpect(jsonPath("$[0].name").value("javatars"))
                .andExpect((jsonPath("$[1].id").value(5)))
                .andExpect(jsonPath("$[1].name").value("javenturiers"));
    }

    @Test
    public void testFindById() throws Exception {
        // Setup
        Promotion javatar = new Promotion(9, "javatar", LocalDate.of(2023, 12,21), new HashSet<>(), new HashSet<>());

        given(promotionService.findById(9)).willReturn(javatar);

        // Test
        ResultActions result = mockMvc.perform(get("/promotions/9")
                .contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(javatar.getId()))
                .andExpect(jsonPath("$.name").value(javatar.getName()));
    }
}