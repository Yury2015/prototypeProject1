package com.company;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Client implements Runnable {
    int target;
    ArrayList<InputMessage> inputMessages;
    Dispatcher dispatcher = Dispatcher.getInstance();

    public Client(int target, int number) {
        this.target = target;
        inputMessages = new ArrayList<InputMessage>(number);
        for (int i = 0; i < number; i++) {
            inputMessages.add(new InputMessage(target));
        }
    }

    public void run() {
        int result;
        for (InputMessage m : inputMessages) {
            result = dispatcher.sendMessage(m);
            System.out.println("Dispatcher id = " + result + ", Executer id = " + m.getTaget() + ", " + Thread.currentThread().getName());
        }
    }
}
