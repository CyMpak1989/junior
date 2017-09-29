package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Random;

/**
 * Class Tracker.
 *
 * @author CyMpak1989 (cympak2009@mail.ru)
 * @version 1.0
 * @since 29.09.2017
 */
public class Tracker {
    /**
     * Массив заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Позиция следующего элемента для массива.
     */
    private int position = 0;
    /**
     * Статическая ссылка на объект рандом.
     */
    private static final Random RN = new Random();

    /**
     * Метод add добавляет новую заявку.
     *
     * @param item входящий параметр Item
     * @return вернем заявку
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод findById производит поиск задачи по id.
     *
     * @param id принимаем входящий параметр id
     * @return вернем найденную заявку по id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод generateId генерирует уникальный id для задачи.
     *
     * @return вернем уникальный id в виде String
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод getAll вернет массив всех задач.
     *
     * @return вернет массив задач
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод update обновляет задачу.
     *
     * @param item входящий параметр объект задачи
     */
    public void update(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод delete удаляет задачу.
     *
     * @param item входящий параметр в виде объекта Item
     */
    public void delete(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = null;
                break;
            }
        }
    }

    /**
     * Метод findByName ищет в массиве все задачи по имени.
     * @param key принимаем имя задачи в виде String1
     * @return вернем массив найденных задач
     */
    public Item[] findByName(String key) {
        int arrayIndex = 0;
        int index = 0;

        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                arrayIndex++;
            }
        }

        Item[] result = new Item[arrayIndex];

        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result[index++] = item;
            }
        }

        return result;
    }

    /**
     * Массив findAll ищет все задачи.
     * @return вернем массив задач без пустых ссылок
     */
    public Item[] findAll() {

        int arrayIndex = 0;
        int index = 0;
        for (Item item : this.items) {
            if (item != null) {
                arrayIndex++;
            }
        }
        Item[] itemsNew = new Item[arrayIndex];
        for (Item item : this.items) {
            if (item != null) {
                itemsNew[index++] = item;
            }
        }

        return itemsNew;
    }
}
