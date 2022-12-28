package com.stefanpetcu.anagramming;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    private final InputStream originalInputSource = System.in;
    private final PrintStream originalOutputDestination = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInputSource);
        System.setOut(originalOutputDestination);
    }

    @Test()
    public void main_willReturnAppeal_givenInputWordAppleAndDictionaryContainingAppeal() {
        System.setIn(new ByteArrayInputStream("Apple; Appeal, Forest, Appebl".getBytes()));
        Main.main(new String[]{});

        assertThat(outputStreamCaptor.toString(),
                equalTo("Please enter a word and a dictionary <word>; <dictionary_word1>, <dictionary_word2>:" +
                        " Appeal, Appebl\n"));
    }
}
