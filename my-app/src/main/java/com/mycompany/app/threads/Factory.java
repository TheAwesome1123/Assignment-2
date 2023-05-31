package com.mycompany.app.threads;

import java.util.concurrent.ThreadFactory;

public class Factory implements ThreadFactory  {
    public Thread newThread(Runnable r) {
        return new AnimalThread();
    }
}
