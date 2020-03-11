package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Данные о составе экипажей
 */
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

    /**
     * Экипаж
     */
    @JoinColumn(name = "shuttle_id")
    @ManyToOne(targetEntity = Shuttle.class, fetch = FetchType.LAZY)
    private Shuttle shuttle;

    /**
     * Доброволец
     */
    @JoinColumn(name = "vol_id")
    @ManyToOne(targetEntity = Volunteer.class, fetch = FetchType.LAZY)
    private Volunteer shuttleOwner;

    /**
     * Признак "Водитель"
     */
    @Column(name = "is_driver")
    private boolean driver;

}
