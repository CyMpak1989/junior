package ru.job4j.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

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
    public void addStore(String name) {
        userList.add(new User(id, name));
        id++;
    }

    @Override
    public void updateStore(int id, String name) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
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
        User userResault = null;
        for (User user : userList) {
            if (user.getId() == id) {
                userResault = user;
            }
        }
        return userResault;
    }
}
