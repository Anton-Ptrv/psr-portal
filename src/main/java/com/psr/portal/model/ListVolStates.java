package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Статусы волонтеров
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "listVolStates")
@Table(name = "list_vol_states")
public class ListVolStates {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
}
