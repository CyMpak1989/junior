package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

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

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public void update(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    public void delete(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = null;
                break;
            }
        }
    }

    public Item findByName(String key) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] itemsNew = new Item[this.items.length];
        int position = 0;
        for (Item item : this.items) {
            if (item != null) {
                itemsNew[position++] = item;
            }
        }

        return itemsNew;
    }
}
