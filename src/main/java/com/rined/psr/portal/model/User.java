package com.rined.psr.portal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Список пользователей
 */
@Getter
@ToString
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "fio")
    private String fio;

    public User(String login, String password, String fio) {
        this.login = login;
        this.password = password;
        this.fio = fio;
    }
}
