package com.company;

import java.util.HashMap;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Dispatcher {

    private static Dispatcher instance;
    private static int id = 0;
    public final static int ERROR_TARGET = -1;
    private static HashMap<Integer, Thread> map = new HashMap<Integer, Thread>();
    private static volatile HashMap<Integer, Thread> messages = new HashMap<Integer, Thread>();


    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        if (null == instance) {
            synchronized (Dispatcher.class) {
                if (null == instance) {
                    instance = new Dispatcher();
                }
            }
        }
        return instance;
    }

    synchronized public int sendMessage(InputMessage message) {
        int target = message.getTaget();

        if (target < 1 || target > 10) {
            return ERROR_TARGET;
        }


        Thread previousThreadOfExecutor = map.get(target);
        Thread createdThreadOfExecutor;

        createdThreadOfExecutor = new Thread(new Executer(new Message(++id, target), previousThreadOfExecutor));

        map.put(target, createdThreadOfExecutor);
        messages.put(id, previousThreadOfExecutor);

        createdThreadOfExecutor.start();
        return id;
    }

    synchronized public static HashMap<Integer, Thread> getMessages() {
        return messages;
    }
}
