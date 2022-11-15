package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String beautifullText1 = poemBeautifier.beautify("Beautify test ", (text -> text.toUpperCase()));
        System.out.println(beautifullText1);

        String beautifullText2 = poemBeautifier.beautify("Beautify test ", (text -> "ABC " + text + "ABC") );
        System.out.println(beautifullText2);

        String beautifullText3 = poemBeautifier.beautify(" Beautify test ", (text -> text.replace(" ", "*")));
        System.out.println(beautifullText3);

        String beautifullText4 = poemBeautifier.beautify("Beautify test ", (text -> text.substring(0, text.length() - 5)));
        System.out.println(beautifullText4);


        //ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        //expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        //expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        //expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        //expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        //System.out.println("Calculating expressions with method references");
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


    }
}
