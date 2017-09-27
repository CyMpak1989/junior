package ru.job4j.Tracker.start;

import ru.job4j.Tracker.models.*;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "Ferst desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName() );
        }
    }
}
