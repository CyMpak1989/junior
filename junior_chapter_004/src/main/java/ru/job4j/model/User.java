package ru.job4j.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Objects;

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
    private String password;
    private String countries;
    private String citi;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {

    }

    public User(int id, String name, String login, String email, Calendar createDate, String password, String countries, String citi) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.countries = countries;
        this.citi = citi;
    }

    public User(String name, String login, String email, Calendar createDate, String password, String countries, String citi) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.countries = countries;
        this.citi = citi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCiti() {
        return citi;
    }

    public void setCiti(String citi) {
        this.citi = citi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(createDate, user.createDate) &&
                Objects.equals(password, user.password) &&
                Objects.equals(citi, user.citi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, createDate, password, citi);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", password='" + password + '\'' +
                ", countries='" + countries + '\'' +
                ", citi='" + citi + '\'' +
                '}';
    }
}
