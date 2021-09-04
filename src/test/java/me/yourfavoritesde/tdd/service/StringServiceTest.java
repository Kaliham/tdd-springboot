package me.yourfavoritesde.tdd.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringServiceTest {
    @Autowired
    StringService stringService;

    @DisplayName("Test setup.")
    @Test
    public void setupCorrect(){
        assertEquals("yes",stringService.yes());
    }
    @DisplayName("Test Capitalization of first letter of each word.")
    @Test
    public void capitalizeFirstLetter(){
        String actualValue = "hello JUnit 5 user";
        String expectedValue = "Hello JUnit 5 User";
        actualValue = stringService.capitalizeFirstLetter(actualValue);
        assertEquals(expectedValue, actualValue);
    }
    @DisplayName("Test Capitalization of first word, of each sentence")
    @Test
    public void capitalizeFirstWord(){
        String actualValue = "hello JUnit 5 user. which you are right?";
        String expectedValue = "Hello JUnit 5 user. Which you are right?";
        actualValue = stringService.capitalizeFirstWord(actualValue);
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("Test Capitalization of one letter words")
    @Test
    public void capitalizeOneLetterWords(){
        String actualValue = "i know who you are, you are a monster";
        String expectedValue = "I know who you are, you are A monster";
        actualValue = stringService.capitalizeOneLetterWords(actualValue);
        assertEquals(expectedValue, actualValue);
    }
}