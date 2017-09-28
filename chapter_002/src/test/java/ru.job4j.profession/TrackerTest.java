package ru.job4j.profession;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;
import ru.job4j.tracker.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Task("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Task("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
}
