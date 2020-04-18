package com.rined.psr.portal.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@DataJpaTest
@DisplayName("Entity должны корректно мапиться на БД")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EntityMappingTest {

    @Autowired
    private TestEntityManager em;

    @Test
    void classification() {
        Long id = em.persistAndGetId(new Classification("МЧС"), Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void psr() {
        PsrState state = em.persist(new PsrState("test"));
        Psr psr = new Psr("psr_name", now(), now(), state, "some test");
        Long id = em.persistAndGetId(psr, Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void psrData() {
        PsrState state = em.persist(new PsrState("test"));
        Psr psr = em.persist(new Psr("psr_name", now(), now(), state, "some test"));
        User lead = em.persist(new User("test_lead_login", "test_password", "Lead Leader Leadov"));
        User user = em.persist(new User("test_login", "test_password", "Tester Test Testovich"));
        byte[] photo = {0x00, 0x01};
        Long id = em.persistAndGetId(
                new PsrData(psr, "station", lead, user, "info", "content", photo),
                Long.class
        );
        assertThat(id).isNotNull();
    }

    @Test
    void psrListRegistration() {
        PsrState state = em.persist(new PsrState("test"));
        Classification cls = em.persist(new Classification("МЧС"));
        VolunteerStatus volunteerStatus = em.persist(new VolunteerStatus("some status"));

        Psr psr = em.persist(new Psr("psr_name", now(), now(), state, "some test"));
        Volunteer volunteer = em.persist(
                new Volunteer("test_fio", true, "555", "telega", cls,
                        "equipment", "list desc", "comment")
        );
        Long id = em.persistAndGetId(
                new PsrListRegistration(psr, volunteer, volunteerStatus, "А888АА",
                        "Test address", LocalDateTime.now(), LocalDateTime.now()), Long.class
        );
        assertThat(id).isNotNull();
    }

    @Test
    void psrState() {
        Long id = em.persistAndGetId(new PsrState("SOME STATE"), Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void shuttle() {
        PsrState state = em.persist(new PsrState("test"));
        Psr psr = em.persist(new Psr("psr_name", now(), now(), state, "some test"));
        Long id = em.persistAndGetId(new Shuttle(psr, "auto"), Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void shuttleData() {
        PsrState state = em.persist(new PsrState("test"));
        Psr psr = em.persist(new Psr("psr_name", now(), now(), state, "some test"));
        Shuttle shuttle = em.persist(new Shuttle(psr, "auto"));
        Classification cls = em.persist(new Classification("МЧС"));
        Volunteer volunteer = em.persist(
                new Volunteer("test_fio", true, "555", "telega", cls,
                        "equipment", "list desc", "comment")
        );
        Long id = em.persistAndGetId(new ShuttleData(shuttle, volunteer, true), Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void user() {
        Long id = em.persistAndGetId(new User("login", "pwd", "Fio"), Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void volunteer() {
        Classification cls = em.persist(new Classification("МЧС"));
        Long id = em.persistAndGetId(
                new Volunteer("test_fio", true, "555", "telega", cls,
                        "equipment", "list desc", "comment"),
                Long.class);
        assertThat(id).isNotNull();
    }

    @Test
    void volunteerStatus() {
        Long id = em.persistAndGetId(new VolunteerStatus("some status"), Long.class);
        assertThat(id).isNotNull();
    }
}