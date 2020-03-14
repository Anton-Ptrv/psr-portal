package com.rined.psr.portal.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * ПСР
 */
@Getter
@NoArgsConstructor
@Entity(name = "psr")
@Table(name = "psr")
public class Psr {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Наименование. Состоит из Адреса + ФИО потерявшегося
     */
    @Column(name = "name")
    private String name;

    /**
     * Дата начала ПСР
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * Дата окончания ПСР
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * Статус(выбирается из спр-ка)
     */
    @JoinColumn(name = "state_id")
    @ManyToOne(targetEntity = PsrState.class, fetch = FetchType.EAGER)
    private PsrState psrState;

    /**
     * Примечание
     */
    @Column(name = "comment")
    private String comment;

    public Psr(String name, LocalDate startDate, LocalDate endDate, PsrState psrState, String comment) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.psrState = psrState;
        this.comment = comment;
    }
}