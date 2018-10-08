package ru.job4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 05.10.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class ValidateStub implements Validate {
    private static final Validate INSTANCE = new ValidateStub();
    private static final Logger LOG = LoggerFactory.getLogger(ValidateStub.class);
    private final Map<Integer, User> store = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public static Validate getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean addValidate(User user) {
        user.setId(counter.getAndIncrement());
        this.store.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean updateValidate(User user) {
        store.replace(user.getId(), user);
        return true;
    }

    @Override
    public boolean deleteValidate(int id) {
        return store.remove(id, store.get(id));
    }

    @Override
    public List<User> findAllValidate() {
        return new ArrayList<User>(this.store.values());
    }

    @Override
    public boolean findByIdValidate(int id) {
        return false;
    }

    @Override
    public boolean isCredentional(String login, String password) {
        return false;
    }

    @Override
    public User findByIdStore(int id) {
        return null;
    }

    @Override
    public List<String> findAllCountries() {
        return null;
    }

    @Override
    public int getUserRoleByLogin(String login) {
        return 0;
    }

    @Override
    public int getUserRole(int id) {
        return 0;
    }

    @Override
    public Map<Integer, String> getAllRole() {
        return null;
    }

    @Override
    public void updateUserRole(String id, String role) {

    }

    @Override
    public void close() {

    }
}
