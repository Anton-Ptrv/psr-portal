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

    @Column(name = "shuttle_id")
    private long shuttleId;

    @Column(name = "vol_id")
    private long volId;

    @Column(name = "is_driver")
    private boolean driver;

}
