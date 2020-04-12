package com.rined.psr.portal.model;

import lombok.*;

import javax.persistence.*;

/**
 * Статусы добровольцев
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volunteerStatus")
@Table(name = "volunteer_status")
@EqualsAndHashCode
public class VolunteerStatus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование статуса добровольца
     */
    @Column(name = "name")
    private String name;

    public VolunteerStatus(String name) {
        this.name = name;
    }
}
