package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

/**
 * Class StartUI.
 *
 * @author CyMpak1989 (cympak2009@mail.ru)
 * @version 1.0
 * @since 29.09.2017
 */
public class StartUI {
    /**
     * Метод для запуска программы.
     * @param args входящие параметры
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("First task", "Ferst desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
    }
}
