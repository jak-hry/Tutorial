package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultListOfForum = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getBirthDate().getYear() >= 20)
                .filter(forumUser -> forumUser.getPostsQty() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        theResultListOfForum.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


        // BookDirectory bookDirectory = new BookDirectory();
        //String theResultStringOfBooks = bookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 205)
        //        .map(Book::toString)
        //        .collect(Collectors.joining(",\n", "<<", ">>"));
        //System.out.println(theResultStringOfBooks);


        //BookDirectory bookDirectory = new BookDirectory();

        //Map<String, Book> theResultMapOfBooks = bookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 2005)
        //        .collect(Collectors.toMap(Book::getSignature, book -> book));

        //System.out.println("# elements: " + theResultMapOfBooks.size());
        //theResultMapOfBooks.entrySet().stream()
        //        .map(entry -> entry.getKey() + ": " + entry.getValue())
        //        .forEach(System.out::println);

        //BookDirectory bookDirectory = new BookDirectory();
        //List<Book> theResultListOfBooks = bookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 2005)
        //        .collect(Collectors.toList());

        //System.out.println("# elements: " + theResultListOfBooks.size());
        //theResultListOfBooks.stream()
        //        .forEach(System.out::println);

        //BookDirectory bookDirectory = new BookDirectory();
        //bookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 2005)
        //        .forEach(System.out::println);

        // People.getList().stream()
        //         .map(String::toUpperCase)
        //         .filter(s -> s.length() > 11)
        //         .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
        //         .filter(s -> s.substring(0, 1).equals("M"))
        //         .forEach(System.out::println);


        //People.getList().stream()
        //        .map(String::toUpperCase)
        //        .forEach(s -> System.out.println(s));

        //People.getList().stream()
        //        .map(s -> s.toUpperCase())                      // [1]
        //        .forEach(System.out::println);

        //System.out.println("Using system to generate even numbers from 1 to 20");
        //NumbersGenerator.generateEven(20);

        //PoemBeautifier poemBeautifier = new PoemBeautifier();

        //String beautifullText1 = poemBeautifier.beautify("Beautify test ", (text -> text.toUpperCase()));
        //System.out.println(beautifullText1);

        //String beautifullText2 = poemBeautifier.beautify("Beautify test ", (text -> "ABC " + text + "ABC") );
        //System.out.println(beautifullText2);

        //String beautifullText3 = poemBeautifier.beautify(" Beautify test ", (text -> text.replace(" ", "*")));
        //System.out.println(beautifullText3);

        //String beautifullText4 = poemBeautifier.beautify("Beautify test ", (text -> text.substring(0, text.length() - 5)));
        //System.out.println(beautifullText4);


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

        //System.out.println("Welcome to module 7 - Stream");

        //SaySomething saySomething = new SaySomething();
        //saySomething.say();

        //Processor processor = new Processor();
        //ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        //processor.execute(executeSaySomething);

        //Executor codeToExecute = () -> System.out.println("This is an example text.");
        //processor.execute(codeToExecute);

        //processor.execute(() -> System.out.println("This is an example text."));

    }
}
