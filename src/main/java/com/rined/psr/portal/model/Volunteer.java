package com.rined.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Справочник Добровольцы
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volunteer")
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "sex")
    private Boolean sex;

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

    public Volunteer(Long id, String fio, boolean sex, String phone, String login, Classification classification) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.phone = phone;
        this.telegramLogin = login;
        this.classification = classification;
    }

    public Volunteer(String fio, boolean sex, String phone, String login, Classification classification) {
        this.fio = fio;
        this.sex = sex;
        this.phone = phone;
        this.telegramLogin = login;
        this.classification = classification;
    }
}
