package ru.job4j.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class MemoreStore implements Store {
    private static final MemoreStore INSTANCE = new MemoreStore();
    private static final Logger LOG = LoggerFactory.getLogger(MemoreStore.class);

    private List<User> userList = new CopyOnWriteArrayList<>();
    private int id = 1;

    public static MemoreStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void addStore(String name, String login, String email) {
        userList.add(new User(id, name, login, email, Calendar.getInstance()));
        id++;
    }

    @Override
    public void updateStore(int id, String name, String login, String email) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
                user.setLogin(login);
                user.setEmail(email);
            }
        }
    }

    @Override
    public void deleteStore(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
            }
        }
    }

    @Override
    public List<User> findAllStore() {
        return userList;
    }

    @Override
    public User findByIdStore(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
