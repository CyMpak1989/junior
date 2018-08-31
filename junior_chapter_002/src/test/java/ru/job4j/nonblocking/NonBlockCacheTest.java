package ru.job4j.nonblocking;

import org.junit.Test;

<<<<<<< HEAD
=======
import java.util.concurrent.atomic.AtomicBoolean;
>>>>>>> b670ba7... task 4741
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NonBlockCacheTest {
    @Test
<<<<<<< HEAD
    public void whenWeExpectAnException() throws Exception {
        Base base = new Base();
        base.setId(1);
        base.setVersion(1);
        NonBlockCache cache = new NonBlockCache();
        cache.add(base);
        AtomicReference<Exception> check = new AtomicReference();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    cache.update(base);
                    System.out.println();
                } catch (OptimisticException e) {
                    check.set(e);
=======
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new OptimisticException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
>>>>>>> b670ba7... task 4741
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            Base base1 = new Base();
            base1.setId(1);
            base1.setVersion(5);
            try {
                cache.update(base1);
            } catch (OptimisticException e) {
                check.set(e);
            }
        });

        thread.start();
        thread1.start();
        thread.join();
<<<<<<< HEAD
        thread1.join();

        assertThat(check.get().getMessage(), is("Model already update"));
=======
        assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }

    @Test
    public void whenExpectExceptionThenException() throws Exception {
        Base base = new Base();
        base.setId(1);
        base.setVersion(1);
        NonBlockCache cache = new NonBlockCache();
        cache.add(base);
        AtomicBoolean check = new AtomicBoolean(false);

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cache.update(base);
                    System.out.println();
                } catch (OptimisticException e) {
                    check.set(true);
                }
            }
        }).start();
        new Thread(() -> {
            Base base1 = new Base();
            base1.setId(1);
            base1.setVersion(5);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cache.update(base1);
            } catch (OptimisticException e) {
                check.set(true);
            }
        }).start();

        Thread.sleep(10);

        assertThat(check.get(), is(true));
>>>>>>> b670ba7... task 4741
    }
}
