package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicLinkedList<E> implements SimpleContainer<E> {
    private int modCount = 0;

    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(E value) {
        Node<E> newElement = new Node<E>(value);
        if (this.first != null) {
            this.first.setNext(newElement);
        }

        this.first = newElement;

        if (this.last == null) {
            this.last = newElement;
        }
        this.modCount++;
    }

    @Override
    public E get(int index) {
        E value = null;

        Iterator<E> iterator = this.iterator();
        for (int i = 0; i <= index; i++) {
            value = iterator.next();
        }
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> element = last;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Ops");
                }
                return this.element != null;
            }

            @Override
            public E next() {
                E value = null;
                if (hasNext()) {
                    value = this.element.getValue();
                    this.element = this.element.getNext();
                }
                return value;
            }
        };
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        private Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
