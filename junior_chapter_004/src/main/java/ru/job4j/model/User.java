package ru.job4j.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 25.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class User {
    private static final Logger LOG = LoggerFactory.getLogger(User.class);
    private int id;
    private String name;
    private String login;
    private String email;
    private Calendar createDate;

    public User(String name, String login, String email, Calendar createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }


    public User(int id, String login, String name, String email, Calendar createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", createDate=" + createDate.getTime()
                + '}';
    }
}
