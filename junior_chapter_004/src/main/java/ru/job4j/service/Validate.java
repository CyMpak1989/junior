package ru.job4j.service;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public interface Validate {
    void addValidate(String name);

    void updateValidate(int id, String name);

    void deleteValidate(int id);

    void findAllValidate();

    void findByIdValidate();
}
