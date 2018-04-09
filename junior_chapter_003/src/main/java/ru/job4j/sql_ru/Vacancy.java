package ru.job4j.sql_ru;

public class Vacancy {
    private String url;
    private String theme;
    private String author;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Vacancy(String url, String theme, String author) {

        this.url = url;
        this.theme = theme;
        this.author = author;
    }
}
