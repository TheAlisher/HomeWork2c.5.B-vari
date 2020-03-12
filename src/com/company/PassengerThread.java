package com.company;

import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {

    Semaphore semaphore;
    private int id;

    PassengerThread(Semaphore sem, int id) {
        this.semaphore = sem;
        this.id = id;
    }

    public synchronized void run(){

        try {
            semaphore.acquire();
            System.out.println("К кассе подошел человек с номером: " + id);

            Thread.sleep(500);

            System.out.println("Из кассы вышел человек c номером: " + id);
            semaphore.release();
            
            if (getId() == 100){
                System.out.println("Автобус полон ");
                System.out.println("Автобус уехал ");
            }

        } catch (Exception E) {
        }
    }

}
