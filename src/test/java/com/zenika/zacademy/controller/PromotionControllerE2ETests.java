package com.zenika.zacademy.controller;

import com.zenika.zacademy.model.Promotion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PromotionControllerE2ETests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindAll() {
        ResponseEntity<Promotion[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/zannuaire/promotions", Promotion[].class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).length).isEqualTo(6);
    }

    @Test
    public void testFindById() {
        ResponseEntity<Promotion> responseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/zannuaire/promotions/1", Promotion.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
    }
}
