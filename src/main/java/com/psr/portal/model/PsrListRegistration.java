package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @JoinColumn(name = "psr_id")
    @ManyToOne(targetEntity = Psr.class, fetch = FetchType.LAZY)
    private Psr psrId;

    @JoinColumn(name = "vol_id")
    @OneToOne(targetEntity = Volunteer.class, fetch = FetchType.LAZY)
    private Volunteer vol_id;

    @JoinColumn(name = "status_id")
    @ManyToOne(targetEntity = VolunteerStatus.class, fetch = FetchType.EAGER)
    private VolunteerStatus status_id;

    @Column(name = "shuttle_num")
    private String shuttleNum;

    @Column(name = "departure_address")
    private String departureAddress;

    @Column(name = "rvp")
    private Timestamp rvp;

    @Column(name = "rvo")
    private Timestamp rvo;

}
