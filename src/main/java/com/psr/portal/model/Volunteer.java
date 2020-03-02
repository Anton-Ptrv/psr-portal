package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Справочник Добровольцев
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volunteer")
@Table(name = "volonteers")
public class Volunteer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "phone")
    private String phone;

    @Column(name = "class_id")
    private long classId;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "psr_list_desc")
    private String psrListDesc;

    @Column(name = "remm")
    private String remm;

}
