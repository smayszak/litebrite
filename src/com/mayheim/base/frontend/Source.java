package com.mayheim.base.frontend;
import com.mayheim.base.message.*;

import java.io.BufferedReader;
import java.io.IOException;

public class Source implements MessageProducer{
    public static final char EOL = '\n'; //end of line character
    public static final char EOF = (char) 0; //end of file character

    private BufferedReader reader; //reader for the source program
    private String line; //source line;
    private int lineNum; //current source line number
    private int currentPos; //current source line position;
    private MessageHandler messageHandler;

    /**
     * Constructor
     * @param reader the reader for the source program
     * @throws IOException if an I/O error occured
     */

    public Source(BufferedReader reader, MessageHandler messageHandler)
        throws IOException{
        this.lineNum = 0;
        this.currentPos = -2; //set to -2 to read the first source line
        this.reader = reader;
        this.messageHandler = messageHandler;
    }

    /**
     * return the soruce character at the current position
     * @return the source character at the current position
     * @throws Exception if an error occurred
     */

    public char currentChar()
    throws Exception{
        //First time?
        if(currentPos == -2) {
            readline();
            return nextChar();
        }
        //at end of file?
        else if (line == null){
            return EOF;
        }
        //at end of line?
        else if ((currentPos == -1) || currentPos == line.length()){
            return EOL;
        }
        //Need to read the next line?
        else if (currentPos > line.length()){
            readline();
            return nextChar();
        }
        else{
            return line.charAt(currentPos);
        }
    }

    /**
     * Consume the current source character and rreturn the next character
     * @return the next source character
     * Exception if an error occured
     */
    public char nextChar()
        throws Exception{
        ++currentPos;
        return currentChar();
    }

    /**
     * Return the source character following the current character without
     * consuming the current characer
     * @return the following character
     * @throws Exception if an error occured
     */
    public char peekAhead()
        throws Exception{
        currentChar();
        if(line == null){
            return EOF;
        }
        int nextPos = currentPos + 1;
        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
     }

    /**
     * read the next source line.
     * @throws IOException if an I.O error occuered
     */
    private void readline()
        throws IOException{
        line = reader.readLine(); // null when at the end of the source
        currentPos = -1;
        if(line != null){
            ++lineNum;
        }

        if(line != null){
            sendMessage(new Message(MessageType.SOURCE_LINE, new Object[] {lineNum, line}));
        }
    }

    /**
     * Close the source.
     * @throws Exception if an error occured
     */
    public void close()
        throws Exception{
        if(reader != null){
            try {
                reader.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    public int getLineNumber() {
        return 0;
    }

    public int getPosition() {
        return 0;
    }

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
