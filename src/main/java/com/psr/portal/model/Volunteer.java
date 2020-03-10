package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "class_id")
    private int classification;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "psr_list_desc")
    private String psrListDesc;

    @Column(name = "comment")
    private String comment;

}
