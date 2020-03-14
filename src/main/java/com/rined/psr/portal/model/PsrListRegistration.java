package com.rined.psr.portal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Лист регистрации участников заявившихся на ПСР
 */
@Getter
@ToString
@NoArgsConstructor
@Entity(name = "psrListRegistration")
@Table(name = "psr_list_registration")
public class PsrListRegistration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDateTime startVolunteerTime;

    /**
     * Расчетное время отбытия волонетра
     */
    @Column(name = "rvo")
    private LocalDateTime endVolunteerTime;

    public PsrListRegistration(Psr psr,
                               Volunteer volunteer,
                               VolunteerStatus volunteerStatus,
                               String shuttleNum,
                               String departureAddress,
                               LocalDateTime startVolunteerTime,
                               LocalDateTime endVolunteerTime) {
        this.psr = psr;
        this.volunteer = volunteer;
        this.volunteerStatus = volunteerStatus;
        this.shuttleNum = shuttleNum;
        this.departureAddress = departureAddress;
        this.startVolunteerTime = startVolunteerTime;
        this.endVolunteerTime = endVolunteerTime;
    }
}
