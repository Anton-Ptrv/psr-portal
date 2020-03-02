package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Список ПСР (заголовки)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "listPsr")
@Table(name = "list_psr")
public class ListPsr {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "state")
    private int state;

    @Column(name = "remm")
    private String remm;
}
