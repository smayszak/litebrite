package com.mayheim.base.message;

public interface MessageProducer {
    void addMessageListener(MessageListener listener);
    void removeMessageListener(MessageListener listener);
    void sendMessage(Message message);
}
