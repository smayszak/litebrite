package com.mayheim.base.frontend;

public class Token {
    protected ITokenType type;//the tokens type
    protected String text; //the tokens text
    protected Object value; //tokens value
    protected Source source;//the source reaer
    protected int lineNumber; //line number of the tokens source line
    protected  int position; //position of th first token character

    public Token(Source source)
        throws Exception {
        this.source = source;
        this.lineNumber = source.getLineNumber();
        this.position = source.getPosition();
    }

    /**
     * Default method to extract only one character tokens from the source
     * subclasses can override the method to construct the lagnguage specific tokens.
     * after extracting the token, the current source line position will
     * be one beyond the last token character.
     * @throws Exception
     */
    protected void extract()
        throws Exception{
        text = Character.toString(currentChar());
        value = null;
        nextChar();//consume current character
    }

    /**
     * Call the sources churrnte char method
     */
    protected char currentChar()
        throws Exception{
        return source.currentChar();
    }

    protected char nextChar()
        throws Exception{
        return source.nextChar();
    }

    protected char peekAhead()
        throws Exception{
        return source.peekAhead();
    }
}
