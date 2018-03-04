package com.mayheim.base.backend;

import com.mayheim.base.intermediate.ICode;
import com.mayheim.base.intermediate.SymbolTable;
import com.mayheim.base.message.MessageHandler;
import com.mayheim.base.message.MessageProducer;

public abstract class Backend implements MessageProducer{
    protected static MessageHandler messageHandler;

    static {
        messageHandler = new MessageHandler();
    }

    protected SymbolTable symbolTable;
    protected ICode iCode;


}
