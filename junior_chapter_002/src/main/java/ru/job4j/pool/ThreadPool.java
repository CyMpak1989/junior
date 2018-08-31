package ru.job4j.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private final int sizeProcessor;

    public ThreadPool() {
        this.sizeProcessor = Runtime.getRuntime().availableProcessors();
    }

    public void work(Runnable job) {

    }

    public void shutdown() {

    }
}
