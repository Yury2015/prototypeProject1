package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
// import org.apache.log4j.Logger;

import static java.lang.Thread.sleep;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Executer implements Runnable {
    private Message message;
    private Thread thread;
    // static Logger log = Logger.getLogger(Executer.class.getName());

    public Executer(Message message, Thread thread) {
        this.message = message;
        this.thread = thread;
    }

    public boolean doWork() throws InterruptedException, IOException {
        if (null != thread) {
            thread.join();
        }

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
            // log.info("Not used InterruptedException in sleep(milliSeconds);");
        }
    }

    public void run() {
        try {
            doWork();
        } catch (IOException e) {
            // log.info("Not used IOException in doWork();");
        } catch (InterruptedException e) {
            // log.info("Not used InterruptedException in doWork();");
            // e.printStackTrace();
        }
    }
}
