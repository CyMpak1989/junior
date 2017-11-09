package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> resault = new TreeSet<>();
        for (User user : list) {
            resault.add(user);
        }

        return resault;
    }
}
