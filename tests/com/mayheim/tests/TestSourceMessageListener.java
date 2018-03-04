package com.mayheim.tests;

import com.mayheim.base.message.Message;
import com.mayheim.base.message.MessageListener;

public class TestSourceMessageListener implements MessageListener {
    public Message LastMessage;
    @Override
    public void messageReceived(Message message) {
        LastMessage = message;
    }
}
