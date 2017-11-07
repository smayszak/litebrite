package com.mayheim.base.frontend;

public abstract class Scanner {

    protected Source source;
    private Token currentToken;

    public Scanner(Source source){
        this.source = source;
    }

    public Token currentToken(){
        return this.currentToken;
    }

    /**
     * Return the next token from source
     * @return
     * @throws Exception
     */
    public Token nextToken()
        throws Exception{

        this.currentToken = extractToken();
        return this.currentToken;
    }

    /**
     * Fo the acutal work of extracing and returning the next token from the source. IMpletmented by the scanner subclasses
     * @return
     * @throws Exception
     */
    protected abstract Token extractToken()
        throws Exception;

    /**
     * Call the source reade current char to return the current char from source
     * @return
     * @throws Exception
     */
    public char currentChar()
        throws Exception{
        return source.currentChar();
    }

    /**
     * Call the sources next char to reutnr that character
     */
    public char nextChar()
        throws Exception{
        return source.nextChar();
    }


}
