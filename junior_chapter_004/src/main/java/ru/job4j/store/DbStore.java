package ru.job4j.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.sql.*;
import java.util.*;
import java.util.Date;
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
            //Создаем таблицу для ролей пользователей.
            sb.append("CREATE TABLE IF NOT EXISTS users_role");
            sb.append("(id   SERIAL PRIMARY KEY,");
            sb.append("role VARCHAR(20));");
            //Добавляем 2 роли пользователей.
//            sb.append("INSERT INTO users_role (role) VALUES ('Administrator');");
//            sb.append("INSERT INTO users_role (role) VALUES ('User');");
            //Создаем таблицу пользователей.
            sb.append("CREATE TABLE IF NOT EXISTS users");
            sb.append("(id     SERIAL PRIMARY KEY, ");
            sb.append("name   VARCHAR(100), ");
            sb.append("login  VARCHAR(100), ");
            sb.append("email  VARCHAR(100), ");
            sb.append("created TIMESTAMP, ");
            sb.append("password VARCHAR(100), ");
            sb.append("type_role INTEGER REFERENCES users_role (id));");
//            sb.append("INSERT INTO users (name, login, email, created, password, type_role) VALUES ('root', 'root', 'root@root.ru', '2018-02-05 12:00:00', 'root', 1);");
            statement.execute(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStore(String name, String login, String email, String password) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, login, email, created, password, type_role) VALUES (?,?,?,?,?,?);")) {
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.setString(5, password);
            ps.setInt(6, 2);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStore(int id, String name, String login, String email, String password) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE Users SET name=?, login=?, email=?, password=? WHERE (id = ?);")) {
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteStore(int id) {
        boolean resault = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Users WHERE (id = ?);")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            resault = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resault;
    }

    @Override
    public List<User> findAllStore() {
        List<User> userList = new CopyOnWriteArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT id, name, login, email, created, password FROM Users;");
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
                user.setPassword(resultSet.getString("password"));
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
             PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, email, created, password FROM Users WHERE (id = ?);")) {
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
                user.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean isCredentional(String login, String password) {
        boolean resulte = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, email, created, password FROM Users WHERE (login = ?);")) {
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String loginDb = resultSet.getString("login");
                String passwordDb = resultSet.getString("password");
                if (login.equals(loginDb) && password.equals(passwordDb)) {
                    resulte = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulte;
    }

    public int getUserRole(int id) {
        int typeRole = 0;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, email, created, password, type_role FROM Users WHERE (id = ?);")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                typeRole = Integer.parseInt(resultSet.getString("type_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeRole;
    }

    public int getUserRoleByLogin(String login) {
        int typeRole = 0;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, email, created, password, type_role FROM Users WHERE (login = ?);")) {
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                typeRole = Integer.parseInt(resultSet.getString("type_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeRole;
    }

    public Map<Integer, String> getAllRole() {
        Map<Integer, String> allRole = new HashMap<>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT id, role FROM users_role;");
            while (resultSet.next()) {
                allRole.put(resultSet.getInt("id"), resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRole;
    }

    public void updateUserRole(String id, String role) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE Users SET type_role=? WHERE (id = ?);")) {
            ps.setInt(1, Integer.parseInt(role));
            ps.setInt(2, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
