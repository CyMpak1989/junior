package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayList<E> implements SimpleContainer<E> {

    private Object[] container = new Object[10];
    private int index = 0;

    @Override
    public void add(E value) {
        checkContainerSize();
        this.container[index++] = value;
    }

    @Override
    public E get(int i) {
        return (E) this.container[i];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                for (int i = iteratorIndex; i < container.length; i++) {
                    if (container[i] != null) {
                        iteratorIndex = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return (E) container[iteratorIndex++];
                } else {
                    throw new NoSuchElementException("NoSuchElementException!");
                }
            }
        };
    }

    private void checkContainerSize() {
        if (this.index == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
    }
}
