package ru.job4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.store.MemoreStore;
import ru.job4j.store.Store;

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
    public void addValidate(String name) {

    }

    @Override
    public void updateValidate(int id, String name) {

    }

    @Override
    public void deleteValidate(int id) {

    }

    @Override
    public void findAllValidate() {

    }

    @Override
    public void findByIdValidate() {

    }
}
