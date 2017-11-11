package ru.job4j.sort;

public class User implements Comparable<User>{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        final int rsl = Integer.compare(this.age, o.age);
        return rsl != 0 ? rsl : -1;
    }
}
