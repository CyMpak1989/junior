package ru.job4j.bank;

public class User {
    public String name;
    public int pasword;

    public User(String name, int pasword) {
        this.name = name;
        this.pasword = pasword;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
