package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TimeCollection {
    Date date = new Date();
    long startTime = 0;
    long endTime = 0;

    public long add(Collection<String> collection, int amount) {
        startTime = date.getTime();
        for (int i = 0; i < amount; i++) {
            collection.add(i + "Тест.");
        }
        endTime = date.getTime();
        return endTime - startTime;
    }

    public long delete(Collection<String> collection, int amount) {
        startTime = date.getTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(i);
        }
        endTime = date.getTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        TimeCollection timeCollection = new TimeCollection();
        Collection<String> stringArrayList = new ArrayList<>();
        System.out.println(timeCollection.add(stringArrayList, 1000));
        System.out.println(timeCollection.delete(stringArrayList, 1000));
    }
}
