package ru.job4j.nonblocking;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockCache {
    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public void add(Base model) {
        cache.put(model.getId(), model);
    }

    public void update(Base model) {
        cache.computeIfPresent(model.getId(), (k, v) -> {
            if (cache.get(k).getVersion() == model.getVersion()) {
                model.setVersion(model.getVersion() + 1);
                return model;
            }
            throw new OptimisticException("Model already update");
        });
    }

    public void delete(Base model) {
        cache.remove(model.getId(), model);
    }
}
