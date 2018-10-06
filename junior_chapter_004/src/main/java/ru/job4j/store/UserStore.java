package ru.job4j.store;

import ru.job4j.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public interface UserStore {
    void addStore(User user);

    void updateStore(User user);

    boolean deleteStore(int id);

    List<User> findAllStore();

    User findByIdStore(int id);

    void closePoolConnections();

    int getUserRole(int id);

    int getUserRoleByLogin(String login);

    void updateUserRole(String id, String role);

    boolean findByLoginStore(String login);

    Map<Integer, String> getAllRole();

    boolean isCredentional(String login, String password);

}
