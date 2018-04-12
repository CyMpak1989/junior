package ru.job4j.sql_ru;

import java.util.concurrent.ArrayBlockingQueue;

public class Parser {
    private ArrayBlockingQueue<Vacancy> queue = new ArrayBlockingQueue<Vacancy>(10000);


    public static void main(String[] args) {
        ParserPages parserPages = new ParserPages();
        parserPages.parsingUrlPage();
    }
}
