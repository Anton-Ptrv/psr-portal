package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Справочник Добровольцы
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volunteer")
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "login_telegram")
    private String telegramLogin;

    @JoinColumn(name = "class_id")
    @ManyToOne(targetEntity = Classification.class, fetch = FetchType.LAZY)
    private Classification classification;

    @Column(name = "equipment")
    private String equipment;

    /**
     * Список работ в которых принимал участие???
     */
    @Column(name = "psr_list_desc")
    private String psrListDesc;

    /**
     * Примечание
     */
    @Column(name = "comment")
    private String comment;

}
