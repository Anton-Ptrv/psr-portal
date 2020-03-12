package com.rined.psr.portal.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * ПСР
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private Date startDate;

    /**
     * Дата окончания ПСР
     */
    @Column(name = "end_date")
    private Date endDate;

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

}
