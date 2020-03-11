package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {

    Semaphore semaphore;
    CountDownLatch CDL;
    private int id;

    PassengerThread(Semaphore sem, CountDownLatch CDL, int id) {
        this.semaphore = sem;
        this.CDL = CDL;
        this.id = id;
    }

    public synchronized void run(){

        try {
            semaphore.acquire();
            System.out.println("К кассе подошел человек с номером: " + id);

            System.out.println("Из кассы вышел человек c номером: " + id);
            semaphore.release();

        } catch (Exception E) {
        }
    }

}
