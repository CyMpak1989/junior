package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSortUser {

    @Test
    public void sortTreeSetTheFirstLessOfTheSecond() {
        assertThat(new User("Vova", 28).compareTo(new User("Roma", 30)), is(-1));
    }

    @Test
    public void sortTreeSetTheFirstMoreThanTheSecond() {
        assertThat(new User("Vova", 30).compareTo(new User("Roma", 28)), is(1));
    }

    @Test
    public void sortTreeSetTheFirstIsEqualToSecond() {
        assertThat(new User("Vova", 30).compareTo(new User("Roma", 30)), is(0));
    }
}
