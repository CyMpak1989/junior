package ru.job4j.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 25.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class SQLQuery {
    private static final Logger LOG = LoggerFactory.getLogger(SQLQuery.class);

    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users(\n"
            + "  id SERIAL PRIMARY KEY ,\n"
            + "  login VARCHAR(100),\n"
            + "  name VARCHAR(100),\n"
            + "  email VARCHAR(100),\n"
            + "  date TIMESTAMP\n"
            + ")";
}
