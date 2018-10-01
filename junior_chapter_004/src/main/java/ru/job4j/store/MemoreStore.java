package ru.job4j.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class MemoreStore implements UserStore, AddressStore {
    private static final MemoreStore INSTANCE = new MemoreStore();
    private static final Logger LOG = LoggerFactory.getLogger(MemoreStore.class);

    private final Map<Integer, User> userStore = new ConcurrentHashMap<>();
    private List<User> userList = new CopyOnWriteArrayList<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public static MemoreStore getInstance() {
        return INSTANCE;
    }

    @Override
    public List<String> findAllCountries() {
        return null;
    }

    @Override
    public List<String> findCitiesByCountry(String name) {
        return null;
    }

    @Override
    public void addStore(User user) {
        user.setId(counter.getAndIncrement());
        userStore.put(user.getId(), user);
    }

    @Override
    public void updateStore(User user) {
        userStore.put(user.getId(), user);
    }

    @Override
    public boolean deleteStore(int id) {
        userStore.remove(id);
        return userStore.containsKey(id);
    }

    @Override
    public List<User> findAllStore() {
        return new ArrayList<>(userStore.values());
    }

    @Override
    public User findByIdStore(int id) {
        return userStore.get(id);
    }

    @Override
    public void closePoolConnections() {

    }

    @Override
    public boolean isCredentional(String login, String password) {
        for (User user : userStore.values()) {
            if (user.getLogin().equals(login) || user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
