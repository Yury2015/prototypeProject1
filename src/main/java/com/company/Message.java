package com.company;

/**
 * Created by Кузнецов Юрий <kuznetsov_yura@mail.ru> on 7/10/2015.
 */
public class Message {
    final String message;
    final int dispatched;
    final int target;

    public Message(int dispatchedId, int targetId) {
        message = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<message>" +
                "<dispatched id=\"" + String.valueOf(dispatchedId) + "\"/>" +
                "<target id=\"" + String.valueOf(targetId) + "\"/>" +
                "<sometags>" +
                "<data> </data>" +
                "<data> </data>" +
                "<data> </data>" +
                "<data> </data>" +
                "</sometags>" +
                "</message>";
        this.dispatched = dispatchedId;
        this.target = targetId;
    }

    public String getMessage() {
        return message;
    }

    public int getDispatched() {
        return dispatched;
    }

    public int getTarget() {
        return target;
    }

}
