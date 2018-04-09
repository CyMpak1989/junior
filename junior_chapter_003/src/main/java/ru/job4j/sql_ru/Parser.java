package ru.job4j.sql_ru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) {
        Document document;
        try {
            document = Jsoup.connect("http://www.sql.ru/forum/job-offers/").get();
            Elements elements = document.getElementsByAttributeValue("class", "postslisttopic");

            for (Element element : elements) {
                //System.out.println(element.getElementsByAttribute("href").text());
                if ((element.getElementsByAttribute("href").text()).contains("Java")) {
                    String text = element.getElementsContainingText("href").text();
                    System.out.println(String.format("%s -> %s", text, element.getElementsByAttribute("href")));
//                    System.out.println(element.getElementsByAttribute("href").text());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
