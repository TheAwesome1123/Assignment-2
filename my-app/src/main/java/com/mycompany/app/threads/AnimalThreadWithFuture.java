package com.mycompany.app.threads;

import com.mycompany.app.abstracts.Animal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AnimalThreadWithFuture {
    private final ExecutorService executor = Executors.newFixedThreadPool(1);

    public Future<String> getAnimalInfoString(Animal animal) {
        return this.executor.submit(animal::toString);
    }
}
