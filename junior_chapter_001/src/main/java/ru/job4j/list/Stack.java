package ru.job4j.list;

/**
 * Коллекция Stack.
 *
 * @param <T> тип коллекции.
 */
public class Stack<T> implements SimpleStackAndQueue<T> {
    /**
     * Ссылка на следующий объект.
     */
    private Node<T> temp;

    @Override
    public T poll() {
        // Присваем переменной ссылку на временный объект.
        Node<T> node = this.temp;
        // Узнаем у текущего объекта ссылку на предыдущий объект. И присваиваем её объекту temp.
        this.temp = node.getNextNode();
        // Удаляем ссылку на объект у текущего.
        node.setNextNode(null);
        // Возвращаем значение текущего объекта.
        return node.getValue();
    }

    @Override
    public void push(T value) {
        // Добавляем временному объекту ссылку на новый объект.
        this.temp = new Node<T>(value, this.temp);
    }

    /**
     * Объект Node.
     *
     * @param <T> тип объекта.
     */
    private class Node<T> {
        /**
         * Значение объекта.
         */
        private final T value;
        /**
         * Ссылка на следующий объект.
         */
        private Node<T> nextNode;

        /**
         * Конструктор объекта.
         *
         * @param value    значение объекта.
         * @param nextNode ссылка на следующий объект.
         */
        public Node(T value, Node<T> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        /**
         * Геттер для значение объекта.
         *
         * @return вернет значение объекта.
         */
        public T getValue() {
            return value;
        }

        /**
         * Геттер для ссылки на следующий объект.
         *
         * @return вернет ссылку на следующий объект.
         */
        public Node<T> getNextNode() {
            return nextNode;
        }

        /**
         * Сеттер задаем ссылку на следующий объект.
         *
         * @param nextNode ссылка на следующий объект.
         */
        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
