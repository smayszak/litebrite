package com.mayheim.tests;

import com.mayheim.base.frontend.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class SourceTest {
    @org.junit.jupiter.api.Test
    void readFileWithContents() {
        String sourceFile = "ab\nc\n\0";
        BufferedReader reader = getReaderForTest(sourceFile);
        try {
            //current char will read the entire file one character one char at a time
            Source source = new Source(reader);
            char currentChar = source.currentChar();//gets first char
            assertEquals(currentChar,'a');
            currentChar = source.nextChar();//reads next char
            assertEquals(currentChar,'b');
            currentChar = source.nextChar();//end of line
            assertEquals(currentChar, Source.EOL);
            currentChar = source.nextChar();//and the next char
            assertEquals(currentChar,'c');
            currentChar = source.nextChar();//end of line
            assertEquals(currentChar, Source.EOL);
            currentChar = source.nextChar();//should now reach the end of th file
            assertEquals(currentChar, Source.EOF);

        }catch (IOException error){
            //if this test ever throws an error we have a problem
            assertNull(error);
        }catch (Exception error){
            //if this test ever throws an error we have a problem
            assertNull(error);
        }
    }
    @org.junit.jupiter.api.Test
    void peekChar() {
        //peek reads one past the current oine without advancing
        String sourceFile = "abc\0";
        BufferedReader reader = getReaderForTest(sourceFile);
        try {
            //current char will read the entire file one character one char at a time
            Source source = new Source(reader);
            char currentChar = source.currentChar();//gets first char
            assertEquals(currentChar,'a');
            currentChar = source.peekAhead();//reads next char
            assertEquals(currentChar,'b');
            currentChar = source.currentChar();//end of line
            assertEquals(currentChar,'a');
            currentChar = source.nextChar();//and the next char
            assertEquals(currentChar,'b');

        }catch (IOException error){
            //if this test ever throws an error we have a problem
            assertNull(error);
        }catch (Exception error) {
            //if this test ever throws an error we have a problem
            assertNull(error);
        }
    }

    @org.junit.jupiter.api.Test
    void close() {
        String sourceFile = "ab\nc\n\0";
        BufferedReader reader = getReaderForTest(sourceFile);
        try {
            //current char will read the entire file one character one char at a time
            Source source = new Source(reader);
            source.close();
            assertNotNull("As long as we do not throw an exception, close is working");
        }catch (IOException error){
            //if this test ever throws an error we have a problem
            assertNull(error);
        }catch (Exception error){
            //if this test ever throws an error we have a problem
            assertNull(error);
        }
    }

    private BufferedReader getReaderForTest(String fakeFile){
        BufferedReader reader = new BufferedReader(new StringReader(fakeFile));
        return reader;

    }

}