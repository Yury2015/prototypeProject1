package com.company;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class InputMessageTest {

    @org.junit.Test
    public void testGetMessage() throws Exception {
        // setUP
        String expected = "<?xml version='1.0' encoding='UTF-8'?><message><target id=\"10\"/><sometags><data> </data><data> </data><data> </data><data> </data></sometags></message>";
        int expectedTarget = 10;

        InputMessage m = new InputMessage(10);

        // verify & verify
        assertEquals(expected, m.getMessage());
        assertEquals(expectedTarget, m.getTaget());
    }
}
