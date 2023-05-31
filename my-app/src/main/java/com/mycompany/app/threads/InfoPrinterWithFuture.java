package com.mycompany.app.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InfoPrinterWithFuture {
    private final ExecutorService executor = Executors.newFixedThreadPool(1);

    public Future<String> getStringToPrint() {
        return this.executor.submit(() -> "Getting animal info...");
    }
}
