package ru.job4j.set;

import java.util.Arrays;

public class SimpleHashSet<E> {
    private Node<Integer, E>[] arrayNode;
    private int counts = 0;

    public SimpleHashSet() {
        this.arrayNode = new Node[100];
    }

    public boolean add(E e) {
        checkContainerSize();
        if (!contains(e)) {
            arrayNode[e.hashCode() % arrayNode.length] = new Node<>(e.hashCode(), e);
            counts++;
            return true;
        }
        return false;
    }

    public boolean contains(E e) {
        return (arrayNode[e.hashCode() % arrayNode.length] != null) ? true : false;
    }

    public boolean remove(E e) {
        if (contains(e)) {
            arrayNode[e.hashCode() % arrayNode.length] = null;
            return true;
        }
        return false;
    }

    private void checkContainerSize() {
        if (this.counts == this.arrayNode.length) {
            this.arrayNode = Arrays.copyOf(this.arrayNode, this.arrayNode.length * 2);
        }
    }

    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
