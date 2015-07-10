package com.company;

import java.util.ArrayList;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Main {
    private static final int N = 100;
    private static final int K = 10;
    private static ArrayList<Thread> clients = new ArrayList<Thread>(N);

    public static void main(String... args) throws InterruptedException {
        for (int i = 0; i < N; i++) {
            int id = (i % K) + 1;
            Thread t = new Thread(new Client(id, K));
            clients.add(i, t);
        }

        for (Thread t : clients) {
            t.start();
        }

        for (Thread t : clients) {
            t.join();
        }
    }
}
