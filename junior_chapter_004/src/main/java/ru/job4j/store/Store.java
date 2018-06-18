package ru.job4j.store;

import ru.job4j.model.User;

import java.util.List;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public interface Store {
    void addStore(String name);

    void updateStore(int id, String name);

    void deleteStore(int id);

    List<User> findAllStore();

    void findByIdStore();
}
