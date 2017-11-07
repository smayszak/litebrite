package com.mayheim.base.frontend.tokenImpl;

import com.mayheim.base.frontend.Source;
import com.mayheim.base.frontend.Token;

public class EofToken extends Token{
    public EofToken(Source reader)
        throws Exception{
        super(reader);
    }
    /**
     * Do nothing, do not consume an source character
     * s
     */
    protected void extract(Source reader)
        throws Exception{

    }
}
