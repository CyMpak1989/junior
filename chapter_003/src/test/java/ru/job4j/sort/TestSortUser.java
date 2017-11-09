package ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sort.SortUser;
import ru.job4j.sort.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSortUser {

    @Test
    public void sortUserTreeSet() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vova", 29),
                new User("Petya", 35),
                new User("Roma", 31),
                new User("Sasha", 30)
        ));
        Set<User> result = sortUser.sort(users);
        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(
                new User("Petya", 35),
                new User("Roma", 31),
                new User("Sasha", 30),
                new User("Vova", 29)
        ));
        assertThat(result, is(expected));
    }

}
