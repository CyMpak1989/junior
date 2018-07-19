package ru.job4j.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 12.07.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();

    private static final Logger LOG = LoggerFactory.getLogger(DbStore.class);

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void closePoolConnections() {
        try {
            SOURCE.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DbStore() {
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/dbstore");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("postgres");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = SOURCE.getConnection();
             Statement statement = connection.createStatement()) {
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
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, login, email, created) VALUES (?,?,?,?);")) {
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
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE Users SET name=?, login=?, email=? WHERE (id = ?);")) {
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStore(int id) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Users WHERE (id = ?);")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAllStore() {
        List<User> userList = new CopyOnWriteArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT id, name, login, email, created FROM Users;");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                Calendar calendar = Calendar.getInstance();
                Timestamp timestamp = new Timestamp(resultSet.getTimestamp("created").getTime());
                calendar.setTime(new Date(timestamp.getTime()));
                user.setCreateDate(calendar);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findByIdStore(int id) {
        User user = new User();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, email, created FROM Users WHERE (id = ?);")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                Calendar calendar = Calendar.getInstance();
                Timestamp timestamp = new Timestamp(resultSet.getTimestamp("created").getTime());
                calendar.setTime(new Date(timestamp.getTime()));
                user.setCreateDate(calendar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
