package ru.job4j.sql_ru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Pattern;

public class Parser {
    public static void main(String[] args) {
        Document document;
        try {
            document = Jsoup.connect("http://www.sql.ru/forum/job-offers/1").get();
            Elements elements = document.getElementsByAttributeValue("class", "postslisttopic");
            //Elements elements = document.getElementsByTag("tr");
            System.out.println(elements.size());
            for (Element element : elements) {
                String url = element.getElementsByTag("a").attr("href");
                String text = element.getElementsByTag("a").eachText().get(0);
                if (Pattern.compile("[j,J]ava\\s?(?=SE/EE|SE|EE)?(?!\\s?[s,S]cript)").matcher(text).find()) {
                    System.out.println(url + " " + text);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
