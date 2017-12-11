package ru.job4j.generic;

public class Role extends Base {
    private String id;

    @Override
    String getId() {
        return this.id;
    }

    @Override
    void setId(String id) {
        this.id = id;
    }
}
