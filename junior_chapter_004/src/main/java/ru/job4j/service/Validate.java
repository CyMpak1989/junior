package ru.job4j.service;

import ru.job4j.model.User;

import java.util.List;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public interface Validate {
    boolean addValidate(String name);

    boolean updateValidate(int id, String name);

    boolean deleteValidate(int id);

    List<User> findAllValidate();

    boolean findByIdValidate(int id);
}
