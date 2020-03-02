package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

/**
 * Лист регистрации участников заявившихся на ПСР
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psrListRegistration")
@Table(name = "psr_list_registration")
public class PsrListRegistration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "psr_list_id")
    private long psrListId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "is_auto")
    private boolean isAuto;

    @Column(name = "shuttle_num")
    private String shuttleNum;

    @Column(name = "class_id")
    private long classId;

    @Column(name = "rvp")
    private Time rvp;

    @Column(name = "rvo")
    private Time rvo;
}
