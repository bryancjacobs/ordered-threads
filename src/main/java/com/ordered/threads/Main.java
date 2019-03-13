package com.ordered.threads;

import com.ordered.threads.worker.WorkerManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean shouldSleep;

        try {
            shouldSleep = Boolean.valueOf(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {

            shouldSleep = true;
        }

        new WorkerManager(shouldSleep).run();
    }
}