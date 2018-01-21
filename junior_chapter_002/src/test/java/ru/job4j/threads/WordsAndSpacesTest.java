package ru.job4j.threads;

import org.junit.Test;

public class WordsAndSpacesTest {
    @Test
    public void text() throws Exception {
        WordsAndSpaces wordsAndSpaces = new WordsAndSpaces();
        wordsAndSpaces.text("Привет Как дела ?");
    }
}
