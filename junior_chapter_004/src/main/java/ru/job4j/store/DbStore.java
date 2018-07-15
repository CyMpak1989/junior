package ru.job4j.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 12.07.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbStore INSTANCE = new DbStore();

    private static final Logger LOG = LoggerFactory.getLogger(DbStore.class);

    public static DbStore getInstance() {
        return INSTANCE;
    }

    public DbStore() {
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/dbstore");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("postgres");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        try (Connection connection = SOURCE.getConnection()) {
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS users");
            sb.append("(id     SERIAL PRIMARY KEY, ");
            sb.append("name   VARCHAR(100), ");
            sb.append("login  VARCHAR(100), ");
            sb.append("email  VARCHAR(100), ");
            sb.append("created TIMESTAMP);");
            statement.execute(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStore(String name, String login, String email) {
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, login, email, created) VALUES (?,?,?,?);");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStore(int id, String name, String login, String email) {

    }

    @Override
    public void deleteStore(int id) {

    }

    @Override
    public List<User> findAllStore() {
        return null;
    }

    @Override
    public User findByIdStore(int id) {
        return null;
    }
}
