package com.rined.psr.portal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Статусы добровольцев
 */
@Getter
@NoArgsConstructor
@Entity(name = "volunteerStatus")
@Table(name = "volunteer_status")
public class VolunteerStatus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Наименование статуса добровольца
     */
    @Column(name = "name")
    private String name;

    public VolunteerStatus(String name) {
        this.name = name;
    }
}
