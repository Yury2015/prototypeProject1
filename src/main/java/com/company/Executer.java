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
        String path;
        if (isWindow()) {
            path = getClass().getResource("/" + message.getTarget()).getPath().substring(1);
        } else {
            path = getClass().getResource("/" + message.getTarget()).getPath();
        }
        File f = new File(path + "/message" + message.getDispatched() + ".xml");
        FileOutputStream out = new FileOutputStream(f.getAbsoluteFile());
        out.write(message.getMessage().getBytes());
        out.close();
        delay(3000);
        return true;
    }

    private boolean isWindow() {
        return System.getProperty("os.name").contains("Windows");
    }

    private void delay(int milliSeconds) {
        try {
            sleep(milliSeconds);
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        try {
            doWork();
        } catch (IOException e) {
        }
    }
}
