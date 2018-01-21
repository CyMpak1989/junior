package ru.job4j.threads;

public class WordsAndSpaces {
    public void text(String x) {
        new Thread() {
            @Override
            public void run() {
                new Thread() {
                    @Override
                    public void run() {
                        String[] array = x.split(" ");
                        System.out.println("Колличество слов в тексте: " + array.length);
                    }
                }.start();
                new Thread() {
                    @Override
                    public void run() {
                        char[] chars = x.toCharArray();
                        int counts = 0;
                        for (int i = 0; i < chars.length; i++) {
                            if (chars[i] == ' ') {
                                counts++;
                            }
                        }
                        System.out.println("Количсетво пробелов в тексте: " + counts);
                    }
                }.start();
            }
        }.start();
    }

    public static void main(String[] args) {
        WordsAndSpaces wordsAndSpaces = new WordsAndSpaces();
        wordsAndSpaces.text("Привет как дела ?");
    }
}
