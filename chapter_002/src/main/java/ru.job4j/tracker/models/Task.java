package ru.job4j.tracker.models;

/**
 * Class Task.
 *
 * @author CyMpak1989 (cympak2009@mail.ru)
 * @version 1.0
 * @since 29.09.2017
 */
public class Task extends Item {
    /**
     * Контруктор для объекта Task.
     * @param name имя
     * @param desc дескриптор
     */
    public Task(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    /**
     * Контруктор для объекта Task.
     * @param name имя
     * @param description дескриптор
     * @param create create
     */
    public Task(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Степень выполненности.
     * @return вернем 100%
     */
    public String calculatePrice() {
        return "100%";
    }
}
