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

    @JoinColumn(name = "psr_id")
    @OneToOne(targetEntity = Psr.class, fetch = FetchType.LAZY)
    private Psr psrId;

    @Column(name = "station")
    private String station;

    @JoinColumn(name = "rpsr")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User rpsr;

    @JoinColumn(name = "registrator")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User registrator;

    @Column(name = "object_info")
    private String objectInfo;

    @Column(name = "content")
    private String content;

    @Column(name = "photo")
    private byte[] photo;

}
