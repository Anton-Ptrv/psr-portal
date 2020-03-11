package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shuttleData")
@Table(name = "shuttle_data")
public class ShuttleData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "shuttle_id")
    @OneToOne(targetEntity = Shuttle.class, fetch = FetchType.LAZY)
    private Shuttle shuttleId;

    @JoinColumn(name = "vol_id")
    @OneToOne(targetEntity = Volunteer.class, fetch = FetchType.LAZY)
    private Volunteer volId;

    @Column(name = "is_driver")
    private boolean driver;

}
