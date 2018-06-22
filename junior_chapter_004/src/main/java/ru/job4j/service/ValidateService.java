package ru.job4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;
import ru.job4j.store.MemoreStore;
import ru.job4j.store.Store;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class ValidateService implements Validate {
    private static final ValidateService INSTANCE = new ValidateService();
    private static final Logger LOG = LoggerFactory.getLogger(ValidateService.class);
    private final Store logic = MemoreStore.getInstance();

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean addValidate(String name, String login, String email) {
        for (User user : logic.findAllStore()) {
            if (user.getName().equals(name)) {
                return false;
            }
        }
        logic.addStore(name, login, email);
        return true;
    }

    @Override
    public boolean updateValidate(int id, String name) {
        if (findByIdValidate(id)) {
            logic.updateStore(id, name);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteValidate(int id) {
        if (findByIdValidate(id)) {
            logic.deleteStore(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAllValidate() {
        List<User> validateUserList = new CopyOnWriteArrayList<>();
        for (User user : logic.findAllStore()) {
            if (user != null) {
                validateUserList.add(user);
            }
        }
        return validateUserList;
    }

    @Override
    public boolean findByIdValidate(int id) {
        if (logic.findByIdStore(id) == null) {
            return false;
        }
        return true;
    }
}
