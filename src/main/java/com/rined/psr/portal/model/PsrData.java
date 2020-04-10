package com.rined.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Данные поисково-спасательных работ
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "psrData")
@Table(name = "psr_data")
public class PsrData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "photo")
    private byte[] photo;

    public PsrData(Psr psr,
                   String station,
                   User psrLeader,
                   User psrRegisteredUser,
                   String objectInfo,
                   String content,
                   byte[] photo) {
        this.psr = psr;
        this.station = station;
        this.psrLeader = psrLeader;
        this.psrRegisteredUser = psrRegisteredUser;
        this.objectInfo = objectInfo;
        this.content = content;
        this.photo = photo;
    }
}
