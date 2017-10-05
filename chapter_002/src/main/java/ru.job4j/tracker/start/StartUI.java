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

    /**
     * Метод для запуска программы.
     * @param args входящие параметры
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        while (!EXIT_PROGRAM.equals(input.ask(MENU))){
            if (ADD_NEW_ITEM.equals(input.getKey())){

            } else if (SHOW_ALL_ITEM.equals(input.getKey())){

            } else if (EDIT_ITEM.equals(input.getKey())){

            } else if (DELETE_ITEM.equals(input.getKey())){

            } else if (FIND_ITEM_BY_ID.equals(input.getKey())){

            } else if (FIND_ITEM_BY_NAME.equals(input.getKey())){

            }
        }
    }
    public void addNewItem(){

    }
}
