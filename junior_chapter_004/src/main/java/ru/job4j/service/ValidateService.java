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
    public String addValidate(String name) {
        for (User user : logic.findAllStore()) {
            if (user.getName().equals(name)) {
                return "A user with this name exists!";
            }
        }
        logic.addStore(name);
        return "The user has been added successfully!";
    }

    @Override
    public String updateValidate(int id, String name) {
        for (User user : logic.findAllStore()) {
            if (user.getId() == id) {
                logic.updateStore(id, name);
                return "The user is successfully updated!";
            }
        }
        return "User with this id is not found!";
    }

    @Override
    public void deleteValidate(int id) {

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
    public void findByIdValidate() {

    }
}
