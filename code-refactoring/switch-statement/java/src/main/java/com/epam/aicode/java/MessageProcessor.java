package com.epam.aicode.java;

public class MessageProcessor {

    public void handleMessageError(Message message) {
        String errorCode = message.getErrorCode();
        if (errorCode.equals("100")) {
            throw new MessageException("Exception with code 100 occurred while processing the message");
        }
        if (errorCode.equals("200")) {
            throw new MessageException("Exception with code 200 occurred while processing the message");
        }
        if (errorCode.equals("300")) {
            throw new MessageException("Exception with code 300 occurred while processing the message");
        }
    }
}
