package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Dispatcher {

    private static Dispatcher instance;
    private static int id = 0;
    public final static int ERROR_TARGET = -1;
    private static HashMap<Integer, Thread> map = new HashMap<Integer, Thread>();

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
        id++;

        int target = message.getTaget();

        if (target < 1 || target > 10) {
            return ERROR_TARGET;
        }

        Thread t = map.get(target);
        if (null != t) {
            try {
                t.join();
                map.remove(target);
            } catch (InterruptedException e) {
            }
        }

        Message m = new Message(id, target);
        t = new Thread(new Executer(m));
        map.put(target, t);
        t.start();
        return id;
    }
}
