package ru.job4j.model;

import java.util.List;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 15.10.2018.
 * @version 1.0.
 * @since 0.1.
 */
public interface DAO<T> {
    T add(T item);

    List<T> getall();

    T getId(int id);

    T update(T item);

    T delete(T item);
}
