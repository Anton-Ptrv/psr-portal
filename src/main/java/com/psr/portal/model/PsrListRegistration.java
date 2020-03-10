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

    @Column(name = "psr_id")
    private int psrId;

    @Column(name = "vol_id")
    private int vol_id;

    @Column(name = "status_id")
    private int status_id;

    @Column(name = "shuttle_num")
    private String shuttleNum;

    @Column(name = "departure_address")
    private String departureAddress;

    @Column(name = "rvp")
    private Timestamp rvp;

    @Column(name = "rvo")
    private Timestamp rvo;

}
