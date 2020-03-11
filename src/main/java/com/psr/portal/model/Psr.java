package com.psr.portal.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Перечень ПСР
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psr")
@Table(name = "psr")
public class Psr {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @JoinColumn(name = "state_id")
    @ManyToOne(targetEntity = PsrState.class, fetch = FetchType.EAGER)
    private PsrState state;

    @Column(name = "comment")
    private String comment;

}
