package com.sangeetha.multithreading;

public class SimpleMultithreadingDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread deviceJob1 = new Thread(
                () -> processDevices("JOB-1"),
                "device-worker-1"
        );

        Thread deviceJob2 = new Thread(
                () -> processDevices("JOB-2"),
                "device-worker-2"
        );

        deviceJob1.start();
        deviceJob2.start();

        deviceJob1.join();
        deviceJob2.join();

        System.out.println("Both jobs completed");
    }

    private static void processDevices(String jobName) {
        for (int device = 1; device <= 5; device++) {
            System.out.printf(
                    "%s processed device-%d using %s%n",
                    jobName,
                    device,
                    Thread.currentThread().getName()
            );

            sleep(500);
        }
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(
                    Thread.currentThread().getName() + " was interrupted"
            );
        }
    }
}
