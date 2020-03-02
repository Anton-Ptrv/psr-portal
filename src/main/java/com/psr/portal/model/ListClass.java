package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Классификации - признак по которому разделять добровольцев.
 * Название кваливикации: местный, мчс, ЛА.
 * Может быть любой по желанию заказчика.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "listClass")
@Table(name = "list_class")
public class ListClass {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "remm")
    private String remm;

}
