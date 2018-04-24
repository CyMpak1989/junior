package ru.job4j.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.sql.*;
import java.util.Calendar;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 25.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class UserStore {
    private static final Logger LOG = LoggerFactory.getLogger(UserStore.class);
    private static final UserStore INSTANCE = new UserStore();
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/test";
    private String username = "postgres";
    private String password = "postgres";

    private UserStore() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            createTable();
            LOG.debug("Соединение установленно!");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UserStore getInstance() {
        return INSTANCE;
    }

    /**
     * Метод createTable для создания таблицы в БД.
     */
    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLQuery.CREATE_TABLE_USERS);
            LOG.debug("Таблица создана или уже имеется.");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public boolean addNewUser(User user) {
        User userTest = getUserLogin(user.getLogin());
        try {
            if (userTest == null) {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO users (login, name, email, date) VALUES (?, ?, ?, ?)");
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
                ps.setTimestamp(4, new Timestamp(user.getCreateDate().getTimeInMillis()));
                ps.executeUpdate();
                LOG.debug("Добавлен новый пользователь: " + user.getLogin());
                return true;
            } else {
                LOG.error("This login is already busy.");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return false;
    }

    public User getUserLogin(String login) {
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String login1 = rs.getString("login");
                String name = rs.getString("name");
                String email = rs.getString("email");
                long date = rs.getTimestamp("date").getTime();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(date);
                user = new User(name, login1, email, calendar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int updateUser(User user) {
        int resault = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, login = ?, email = ? WHERE login = ?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getLogin());
            resault = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return resault;
    }

    public int daleteUser(String login) {
        int resault = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE login = ?");
            ps.setString(1, login);
            resault = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return resault;
    }
}
