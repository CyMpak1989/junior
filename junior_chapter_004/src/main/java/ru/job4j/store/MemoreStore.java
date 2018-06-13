package ru.job4j.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class MemoreStore implements Store {
    private static final MemoreStore INSTANCE = new MemoreStore();
    private static final Logger LOG = LoggerFactory.getLogger(MemoreStore.class);

    public static MemoreStore getInstance() {
        return INSTANCE;
    }
}
