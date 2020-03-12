package com.rined.psr.portal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Справочник Добровольцы
 */
@Getter
@NoArgsConstructor
@Entity(name = "volunteer")
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Volunteer(String fio,
                     boolean sex,
                     String phone,
                     String telegramLogin,
                     Classification classification,
                     String equipment,
                     String psrListDesc,
                     String comment) {
        this.fio = fio;
        this.sex = sex;
        this.phone = phone;
        this.telegramLogin = telegramLogin;
        this.classification = classification;
        this.equipment = equipment;
        this.psrListDesc = psrListDesc;
        this.comment = comment;
    }
}
