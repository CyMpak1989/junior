package ru.job4j.collection;

import java.util.*;

/**
 * ConvertList.
 */
public class ConvertList {
    /**
     * Конвертируем в List.
     *
     * @param array принимаем массив int[][].
     * @return вернем ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        for (int[] a : array) {
            for (int x : a) {
                integerList.add(x);
            }
            System.out.println();
        }
        return integerList;
    }

    /**
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int length;
        Iterator<Integer> iterator = list.iterator();
        if (list.size() % rows == 0) {
            length = list.size() / rows;
        } else {
            length = (list.size() / rows) + 1;
        }

        int[][] array = new int[rows][length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                if (iterator.hasNext()) {
                    Integer temp = iterator.next();
                    if (temp != null) {
                        array[i][j] = temp;
                    } else {
                        array[i][j] = 0;
                    }
                }
            }
        }
        return array;
    }
}
