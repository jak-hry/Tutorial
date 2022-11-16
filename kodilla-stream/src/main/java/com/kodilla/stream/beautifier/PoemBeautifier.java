package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beautify(String text2, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(text2);
    }
}
