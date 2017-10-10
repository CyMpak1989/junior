package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;

/**
 * Class MenuTracker.
 *
 * @author CyMpak1989 (cympak2009@mail.ru)
 * @version 1.0
 * @since 11.10.2017
 */
public class MenuTracker {
    /**
     * Приветная переменная для объекта Input.
     */
    private Input input;
    /**
     * Приватная переменная для объекта Tracker.
     */
    private Tracker tracker;
    /**
     * Массив для реализаций интерфейсов.
     */
    private UserAction[] actions = new UserAction[6];

    /**
     * Конструкторм класса MenuTracker.
     * @param input принимаем ссылку на объект Input.
     * @param tracker принимаем ссылку на объект Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для инициализации массива.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
    }

    /**
     * Метод для вызова необходимой реализации интерфейса из массива.
      * @param key принимае номер пункта меню.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод для отображения меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Реализация пункта меню Add new Item.
     */
    private static class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Пожалуйста введите имя задачи: ");
            String desc = input.ask("Пожалуйста введите дескрипшион: ");
            tracker.add(new Task(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item.");
        }
    }

    /**
     * Реализация пункта меню Show all items.
     */
    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Реализация пункта меню Edit item.
     */
    private static class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Введите id заявки которую необходимо отредактировать: "));
            Item newItem = new Task(input.ask("Введите имя заявки: "), input.ask("Введите дескприптор: "));
            newItem.setId(item.getId());
            tracker.update(newItem);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * Реализация пункта меню Delete item.
     */
    private static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Введите id заявки которую необходимо удалить: "));
            tracker.delete(item);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    /**
     * Реализация пункта меню Find item by Id.
     */
    private static class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Введите id для поиска заявки: "));
            System.out.println(item.toString());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }

    /**
     * Реализация пункта меню Find items by name.
     */
    private static class FindItemByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findByName(input.ask("Введите имя заявки которую хотите найти: "));
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }
    }

}
