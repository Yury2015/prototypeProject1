package com.company;

/**
 * Created by  узнецов ёрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class InputMessage {
    final String message;
    final int taget;

    public InputMessage(int targetId) {
        message = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<message>" +
                "<target id=\"" + String.valueOf(targetId) + "\"/>" +
                "<sometags>" +
                "<data> </data>" +
                "<data> </data>" +
                "<data> </data>" +
                "<data> </data>" +
                "</sometags>" +
                "</message>";
        this.taget = targetId;
    }

    public String getMessage() {
        return message;
    }

    public int getTaget() {
        return taget;
    }
}
