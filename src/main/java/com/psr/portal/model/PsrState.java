package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Статусы ПСР
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psrStates")
@Table(name = "psr_states")
public class PsrState {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

}
