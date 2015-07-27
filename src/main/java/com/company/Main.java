package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("All clients finished and Dispatcher finished.");

        waitForAllExecutors();

        System.exit(0);
    }

    private static void waitForAllExecutors() throws InterruptedException {
        System.out.println("Wait to finish all executors...");
        while (true) {
            if (NUMBER_OF_MESSAGES >= Dispatcher.getInstance().getMessages().size()) {
                break;
            }
        }

        HashMap<Integer, Thread> messages = Dispatcher.getInstance().getMessages();
        ArrayList<Integer> removeIdList = new ArrayList<Integer>();
        for (Map.Entry<Integer, Thread> m : messages.entrySet()) {
            if (null != m.getValue()) {
                m.getValue().join();
            }
            ;
            if (null != m.getKey()) {
                System.out.println("Message id = " + m.getKey() + " is done.");
            }
        }
    }
}
