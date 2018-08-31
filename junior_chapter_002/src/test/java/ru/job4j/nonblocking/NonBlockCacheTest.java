package ru.job4j.nonblocking;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NonBlockCacheTest {


    @Test
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
        thread1.join();

        assertThat(check.get().getMessage(), is("Model already update"));

    }
}
