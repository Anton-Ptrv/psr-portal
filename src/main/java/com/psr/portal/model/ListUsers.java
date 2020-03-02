package com.psr.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Список пользователей
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "listUsers")
@Table(name = "list_users")
public class ListUsers {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}
