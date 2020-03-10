package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psrData")
@Table(name = "psr_data")
public class PsrData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "psr_id")
    private int psrId;

    @Column(name = "station")
    private String station;

    @Column(name = "rpsr")
    private int rpsr;

    @Column(name = "registrator")
    private int registrator;

    @Column(name = "object_info")
    private String objectInfo;

    @Column(name = "content")
    private String content;

    @Column(name = "photo")
    private byte[] photo;

}
