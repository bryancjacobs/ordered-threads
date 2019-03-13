package com.ordered.threads;

import com.ordered.threads.worker.WorkerManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new WorkerManager(true).run();
    }
}