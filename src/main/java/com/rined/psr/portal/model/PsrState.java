package com.rined.psr.portal.model;

import lombok.*;

import javax.persistence.*;

/**
 * Статусы ПСР
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psrStates")
@Table(name = "psr_states")
@EqualsAndHashCode
public class PsrState {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование статуса
     */
    @Column(name = "name")
    private String name;

    public PsrState(String name) {
        this.name = name;
    }
}
