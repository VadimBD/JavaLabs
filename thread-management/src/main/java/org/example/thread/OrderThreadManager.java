package org.example.thread;

public class OrderThreadManager {
    public static void startProcessing(Runnable task) {
        new Thread(task).start();
    }
}
