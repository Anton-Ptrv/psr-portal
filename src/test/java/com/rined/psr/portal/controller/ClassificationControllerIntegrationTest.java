package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.Classification;
import com.rined.psr.portal.model.dto.brief.ClassificationBrief;
import com.rined.psr.portal.model.dto.fully.ClassificationDto;
import com.rined.psr.portal.repositories.ClassificationRepository;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(value = {"/scripts/classification-test-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ClassificationControllerIntegrationTest {

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ClassificationRepository repository;

    @BeforeEach
    void setUp() {
        url = "/psr/api/classification";
    }

    @Test
    void createNew() {
        val brief = new ClassificationBrief(UUID.randomUUID().toString());
        assertThat(restTemplate.postForEntity(url, brief, Void.class)
                .getStatusCode())
                .isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getAll() {
        val response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ClassificationDto>>() {
                }
        );
        assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(response.getBody()).hasSize(2),
                () -> assertThat(response.getBody())
                        .containsOnly(of(1L, "ТЕСТ1"), of(2L, "ТЕСТ2"))
        );
    }

    @Test
    void update() {
        val ID = 1L;
        val NAME = "NEW_TEST";

        val urlById = String.format("%s/%d", url, ID);
        val request = new HttpEntity<>(of(ID, NAME));
        ResponseEntity<Void> response = restTemplate.exchange(
                urlById,
                HttpMethod.PUT,
                request,
                new ParameterizedTypeReference<Void>() {
                }
        );
        assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(repository.findById(ID).orElse(new Classification(-1)))
                        .isEqualTo(new Classification(ID, NAME))
        );
    }

    @Test
    void getById() {
        val urlById = String.format("%s/%d", url, 1L);
        ResponseEntity<ClassificationDto> response = restTemplate.getForEntity(urlById, ClassificationDto.class);
        assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(response.getBody()).isEqualTo(of(1L, "ТЕСТ1"))
        );
    }

    @Test
    void deleteById() {
        val ID = 1L;
        val urlById = String.format("%s/%d", url, ID);
        ResponseEntity<List<ClassificationDto>> response = restTemplate.exchange(
                urlById,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<List<ClassificationDto>>() {
                }
        );

        assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(repository.existsById(ID)).isFalse()
        );
    }

    ClassificationDto of(Long id, String name) {
        return new ClassificationDto(id, name);
    }
}