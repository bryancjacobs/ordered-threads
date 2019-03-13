package com.ordered.threads.worker;

import java.util.concurrent.Callable;

public class Worker implements Callable<String> {

    private String name;

    private int value;

    Worker(String name, int value) {

        this.name = name;

        this.value = value;
    }

    public String call() {
        return name + ":" + value;
    }
}
