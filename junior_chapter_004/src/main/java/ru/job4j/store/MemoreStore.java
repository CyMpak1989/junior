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

    public static MemoreStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void addStore(String name) {

    }

    @Override
    public void updateStore(int id, String name) {

    }

    @Override
    public void deleteStore(int id) {

    }

    @Override
    public void findAllStore() {

    }

    @Override
    public void findByIdStore() {

    }
}
