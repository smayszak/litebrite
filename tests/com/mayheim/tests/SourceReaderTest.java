package com.mayheim.tests;

import com.mayheim.base.frontend.SourceReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class SourceReaderTest {
    @org.junit.jupiter.api.Test
    void readFileWithContents() {
        String sourceFile = "ab\nc\n\0";
        BufferedReader reader = getReaderForTest(sourceFile);
        try {
            //current char will read the entire file one character one char at a time
            SourceReader sourceReader = new SourceReader(reader);
            char currentChar = sourceReader.currentChar();//gets first char
            assertEquals(currentChar,'a');
            currentChar = sourceReader.nextChar();//reads next char
            assertEquals(currentChar,'b');
            currentChar = sourceReader.nextChar();//end of line
            assertEquals(currentChar, SourceReader.EOL);
            currentChar = sourceReader.nextChar();//and the next char
            assertEquals(currentChar,'c');
            currentChar = sourceReader.nextChar();//end of line
            assertEquals(currentChar, SourceReader.EOL);
            currentChar = sourceReader.nextChar();//should now reach the end of th file
            assertEquals(currentChar, SourceReader.EOF);

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
            SourceReader sourceReader = new SourceReader(reader);
            char currentChar = sourceReader.currentChar();//gets first char
            assertEquals(currentChar,'a');
            currentChar = sourceReader.peekAhead();//reads next char
            assertEquals(currentChar,'b');
            currentChar = sourceReader.currentChar();//end of line
            assertEquals(currentChar,'a');
            currentChar = sourceReader.nextChar();//and the next char
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
            SourceReader sourceReader = new SourceReader(reader);
            sourceReader.close();
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