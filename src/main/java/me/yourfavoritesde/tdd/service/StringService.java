package me.yourfavoritesde.tdd.service;


import org.springframework.stereotype.Component;


public interface StringService {

    public String capitalizeFirstLetter(String text);
    public String capitalizeFirstWord(String text);
    public String capitalizeOneLetterWords(String text);
    public String yes();
}
