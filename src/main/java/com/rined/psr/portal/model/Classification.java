package com.rined.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Классификации - признак по которому разделять добровольцев.
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "classification")
@Table(name = "classifications")
public class Classification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование кваливикации: местный, мчс, ЛА.
     * Может быть любой по желанию заказчика
     */
    @Column(name = "name")
    private String name;

    public Classification(long id) {
        this.id = id;
    }

    public Classification(String name) {
        this.name = name;
    }
}
