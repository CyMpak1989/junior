package ru.job4j.tracker.models;

public class Task extends Item {
    public Task(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public Task(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String calculatePrice() {
        return "100%";
    }
}
