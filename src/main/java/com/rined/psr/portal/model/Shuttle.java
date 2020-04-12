package com.rined.psr.portal.model;

import lombok.*;

import javax.persistence.*;

/**
 * Зарегестрированные на ПСР экипажи
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shuttle")
@Table(name = "shuttles")
@EqualsAndHashCode
public class Shuttle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ПСР на котором зарегестрирован экипаж
     */
    @JoinColumn(name = "psr_id")
    @ManyToOne(targetEntity = Psr.class, fetch = FetchType.LAZY)
    private Psr registeredOnPsr;

    /**
     * Марка и номер машины
     */
    @Column(name = "auto")
    private String auto;

    public Shuttle(Psr registeredOnPsr, String auto) {
        this.registeredOnPsr = registeredOnPsr;
        this.auto = auto;
    }
}
