package ru.job4j.sql_ru.items;

public class Vacancy {
    private String url;
    private String theme;
    private String author;
    private long date;
    private String textVacabcy;

    public Vacancy(String url, String theme, String author, long date, String textVacabcy) {
        this.url = url;
        this.theme = theme;
        this.author = author;
        this.date = date;
        this.textVacabcy = textVacabcy;
    }

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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTextVacabcy() {
        return textVacabcy;
    }

    public void setTextVacabcy(String textVacabcy) {
        this.textVacabcy = textVacabcy;
    }
}
