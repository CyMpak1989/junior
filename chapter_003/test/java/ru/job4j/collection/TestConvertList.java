package java.ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.ConvertList;

import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * Тестовый класс для ConvertList.
 */
public class TestConvertList {
    /**
     * whenConvertListThenGetArray.
     * Из двумерного массива в лист.
     */
    @Test
    public void whenConvertListThenGetArray() {
        int[][] mas = {{7, 6, 5}, {4, 3, 2}, {1, 0, 0}};
        List<Integer> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, 7, 6, 5, 4, 3, 2, 1, 0, 0);
        ConvertList convert = new ConvertList();
        List<Integer> resultList = convert.toList(mas);
        assertThat(resultList, is(expectedList));
    }

    /**
     * whenConvertArrayThenGetList.
     * Из листа в двумерный массив.
     */
    @Test
    public void whenConvertArrayThenGetList() {
        int[][] expectedMas = {{7, 6, 5}, {4, 3, 2}, {1, 0, 0}};
        ConvertList convert = new ConvertList();
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 7, 6, 5, 4, 3, 2, 1);
        int[][] resultMas = convert.toArray(list, 3);
        assertThat(resultMas, is(expectedMas));
    }
}
