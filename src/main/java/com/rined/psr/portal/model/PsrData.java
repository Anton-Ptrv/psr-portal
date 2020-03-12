package com.rined.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Данные поисково-спасательных работ
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psrData")
@Table(name = "psr_data")
public class PsrData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * определенная ПСР
     */
    @JoinColumn(name = "psr_id")
    @OneToOne(targetEntity = Psr.class, fetch = FetchType.LAZY)
    private Psr psr;

    /**
     * Адрес штаба
     */
    @Column(name = "station")
    private String station;

    /**
     * Руководитель ПСР (из спр-ка Пользователи)
     */
    @JoinColumn(name = "rpsr")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User psrLeader;

    /**
     * Регистратор ПСР (из спр-ка Пользователи)
     */
    @JoinColumn(name = "registrator")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User psrRegisteredUser;

    /**
     * Первичная информация о поиске
     */
    @Column(name = "object_info")
    private String objectInfo;

    /**
     * Основная информация о поиске
     */
    @Column(name = "content")
    private String content;

    /**
     * Ориентировка или фотография ОП(объекта поиска)
     */
    @Column(name = "photo")
    private byte[] photo;

}
