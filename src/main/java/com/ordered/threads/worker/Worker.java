package com.ordered.threads.worker;

import java.util.concurrent.Callable;

public class Worker implements Callable<String> {

    private final Long millis;

    private String name;

    private int value;

    Worker(String name, int value, Long millis) {

        this.name = name;

        this.value = value;

        this.millis = millis;
    }

    public String call() throws InterruptedException {

        Thread.sleep(millis);

        return name + ":" + value;
    }
}
