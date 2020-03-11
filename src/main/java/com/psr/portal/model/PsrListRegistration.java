package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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

    /**
     * ПСР (из спр-ка)
     */
    @JoinColumn(name = "psr_id")
    @ManyToOne(targetEntity = Psr.class, fetch = FetchType.LAZY)
    private Psr psr;

    /**
     * Доброволец (из спр-ка)
     */
    @JoinColumn(name = "vol_id")
    @ManyToOne(targetEntity = Volunteer.class, fetch = FetchType.LAZY)
    private Volunteer volunteer;

    /**
     * Статус (ссылка на list_vol_states)
     */
    @JoinColumn(name = "status_id")
    @ManyToOne(targetEntity = VolunteerStatus.class, fetch = FetchType.EAGER)
    private VolunteerStatus volunteerStatus;

    /**
     * Номер экипажа
     */
    @Column(name = "shuttle_num")
    private String shuttleNum;

    /**
     * Адрес отправления
     */
    @Column(name = "departure_address")
    private String departureAddress;

    /**
     * Расчетное время прибытия волонетра
     */
    @Column(name = "rvp")
    private Timestamp startVolunteerTime;

    /**
     * Расчетное время отбытия волонетра
     */
    @Column(name = "rvo")
    private Timestamp endVolunteerTime;

}
