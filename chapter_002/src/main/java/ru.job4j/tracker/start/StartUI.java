package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;

/**
 * Class StartUI.
 *
 * @author CyMpak1989 (cympak2009@mail.ru)
 * @version 1.0
 * @since 29.09.2017
 */
public class StartUI {
    private Input input;
    private static final String ADD_NEW_ITEM = "0";
    private static final String SHOW_ALL_ITEM = "1";
    private static final String EDIT_ITEM = "2";
    private static final String DELETE_ITEM = "3";
    private static final String FIND_ITEM_BY_ID = "4";
    private static final String FIND_ITEM_BY_NAME = "5";
    private static final String EXIT_PROGRAM = "6";
    private static final String MENU = "0. Add new Item\n" +
            "1. Show all items\n" +
            "2. Edit item\n" +
            "3. Delete item\n" +
            "4. Find item by Id\n" +
            "5. Find items by name\n" +
            "6. Exit Program\n" +
            "Select:";

    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Метод для запуска программы.
     *
     * @param args входящие параметры
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }

    public void init() {
        Tracker tracker = new Tracker();
        while (!EXIT_PROGRAM.equals(this.input.ask(MENU))) {
            if (ADD_NEW_ITEM.equals(this.input.getKey())) {
                addNewItem(this.input, tracker);
            } else if (SHOW_ALL_ITEM.equals(this.input.getKey())) {
                showAllItem(tracker);
            } else if (EDIT_ITEM.equals(this.input.getKey())) {
                editItem(this.input, tracker);
            } else if (DELETE_ITEM.equals(this.input.getKey())) {

            } else if (FIND_ITEM_BY_ID.equals(this.input.getKey())) {

            } else if (FIND_ITEM_BY_NAME.equals(this.input.getKey())) {

            }
        }
    }

    public void addNewItem(Input input, Tracker tracker) {
        Item item = new Task(input.ask("Введите имя заявки: "), input.ask("Введите дескприптор: "));
        tracker.add(item);
        System.out.println("Новая заявка создана!\n");

    }

    public void showAllItem(Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println("Id: " + item.getId() + " Name: " + item.getName() +
                    " Description: " + item.getDescription() + " Create: " + item.getCreate());
        }
        System.out.println("Список всех задач на экране!\n");
    }

    public void editItem(Input input, Tracker tracker){

    }
}
