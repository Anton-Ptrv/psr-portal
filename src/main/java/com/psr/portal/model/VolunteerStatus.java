package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Статусы добровольцев
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volunteerStatus")
@Table(name = "volunteer_status")
public class VolunteerStatus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

}
