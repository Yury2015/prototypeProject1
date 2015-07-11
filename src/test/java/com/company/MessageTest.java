package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class MessageTest {


    @Test
    public void testGetMessage() throws Exception {
        // setup
        String expected = "<?xml version='1.0' encoding='UTF-8'?><message><dispatched id=\"1\"/><target id=\"10\"/><sometags><data> </data><data> </data><data> </data><data> </data></sometags></message>";
        int expectedDispatched = 1;
        int expectedTarget = 10;

        // execute
        Message m = new Message(1, 10);

        // verify
        assertEquals(expected, m.getMessage());
        assertEquals(expectedDispatched, m.getDispatched());
        assertEquals(expectedTarget, m.getTarget());

    }
}
