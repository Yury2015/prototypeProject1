package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Executer implements Runnable {
    Message message;

    public Executer(Message message) {
        this.message = message;
    }

    public boolean doWork() throws IOException {
        int targetId = message.getTarget();
        if (targetId < 1 || targetId > 10) {
            return false;
        }
        String path = getClass().getResource("/" + message.getTarget()).getPath().substring(1);
        //System.out.println(path);
        File f = new File(path + "/message" + message.getDispatched() + ".xml");
        FileOutputStream out = new FileOutputStream(f.getAbsoluteFile());
        out.write(message.getMessage().getBytes());
        out.close();
        delay(3000);
        return true;
    }

    private void delay(int milliSeconds) {
        try {
            sleep(milliSeconds);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String... args) {
        Executer main = new Executer(new Message(1, 2));

        try {
            if (main.doWork()) {
                System.out.println("Исполнитель готов");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            doWork();
        } catch (IOException e) {
        }
    }
}
