package com.company;

import java.util.ArrayList;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Main {
    private static final int NUMBER_OF_MESSAGES = 1000;
    private static final int N = 100;
    private static final int K = 10;
    private static ArrayList<Thread> clients = new ArrayList<Thread>(N);

    public static void main(String... args) throws InterruptedException {
        for (int i = 0; i < N; i++) {
            int id = (i % K) + 1;
            Thread t = new Thread(new Client(id, NUMBER_OF_MESSAGES / N));
            clients.add(i, t);
        }

        for (Thread t : clients) {
            t.start();
        }

        for (Thread t : clients) {
            t.join();
        }

        System.exit(0);
    }
}
