package com.mjc.stage2;

public class ThreadSafeSingleton {
    private volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
