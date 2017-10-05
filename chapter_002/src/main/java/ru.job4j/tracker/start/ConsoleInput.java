package ru.job4j.tracker.start;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String getKey() {
        return key;
    }

    private String key = "";

    @Override
    public String ask(String question) {
        System.out.println(question);
        return key = scanner.nextLine();
    }
}
