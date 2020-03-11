package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Классификации - признак по которому разделять добровольцев.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "classification")
@Table(name = "classifications")
public class Classification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Наименование кваливикации: местный, мчс, ЛА.
     * Может быть любой по желанию заказчика
     */
    @Column(name = "name")
    private String name;

}
