package ru.job4j.wnn;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SimpleBlockingQueueTest {
    private SimpleBlockingQueue<Integer> queue;
    private Thread producer;
    private Thread consumer;

    @Before
    public void setUp() {
        queue = new SimpleBlockingQueue<>();

        producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.offer(i);
                }
            }
        };

        consumer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 8; i++) {
                    try {
                        queue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    @Test
    public void whenAddTenElementsAndRemoveEight() throws InterruptedException {
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        int result = queue.poll();
        assertThat(result, is(8));
    }
}
