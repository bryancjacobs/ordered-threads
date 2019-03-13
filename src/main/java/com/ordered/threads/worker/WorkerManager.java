package com.ordered.threads.worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WorkerManager {

    private final boolean shouldSleep;

    public WorkerManager(boolean shouldSleep) {
        this.shouldSleep = shouldSleep;
    }

    public void run() throws InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<Callable<String>>();

        int counter = 1;

        while (true) {

            if (shouldSleep) {

                Thread.sleep(250);
            }

            callables.clear();

            callables.add(new Worker("T1", counter++));
            callables.add(new Worker("T2", counter++));
            callables.add(new Worker("T3", counter++));

            try {

                List<Future<String>> results = exec.invokeAll(callables);

                for (Future<String> result : results) {

                    System.out.println(result.get());

                }

                System.out.println();

            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        }
    }

}
