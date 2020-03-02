package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Информация ПСР
 */
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

    @Column(name = "psr_list_id")
    private long psrListId;

    @Column(name = "station")
    private String station;

    @Column(name = "rpsr")
    private String rpsr;

    @Column(name = "registrator")
    private int registrator;

    @Column(name = "object_info")
    private String objectInfo;

    @Column(name = "content")
    private String content;

    @Column(name = "foto")
    private byte[] photo;
}
