package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by �������� ���� <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class ExecuterTest {

    @Test
    public void testDoWork() throws Exception {

    }

    @Test
    public void testRun() throws Exception {

        Thread thread = new Thread(new Executer(new Message(1, 1)));
        thread.start();
        thread.join();

    }
}