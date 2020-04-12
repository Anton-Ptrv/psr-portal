package com.rined.psr.portal.model;

import lombok.*;

import javax.persistence.*;

/**
 * Данные о составе экипажей
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shuttleData")
@Table(name = "shuttle_data")
@EqualsAndHashCode
public class ShuttleData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public ShuttleData(Shuttle shuttle, Volunteer shuttleOwner, boolean driver) {
        this.shuttle = shuttle;
        this.shuttleOwner = shuttleOwner;
        this.driver = driver;
    }
}
