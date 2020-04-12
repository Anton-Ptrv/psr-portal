package com.rined.psr.portal.model;

import lombok.*;

import javax.persistence.*;

/**
 * Список пользователей
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "users")
@EqualsAndHashCode
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "fio")
    private String fio;

    public User(long id, String login, String fio) {
        this.id = id;
        this.login = login;
        this.fio = fio;
    }

    public User(String login, String password, String fio) {
        this.login = login;
        this.password = password;
        this.fio = fio;
    }
}
