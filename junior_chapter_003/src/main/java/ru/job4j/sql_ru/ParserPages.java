package ru.job4j.sql_ru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Pattern;

public class ParserPages {
    public void parsingUrlPage() {
        Document document;
        try {
            document = Jsoup.connect("http://www.sql.ru/forum/job-offers").get();
            Elements elementsSortOptions = document.getElementsByAttributeValue("class", "sort_options");
            Elements elements = elementsSortOptions.select("tr");
            Element element = elements.get(1);
            int index = Integer.parseInt(element.getElementsByTag("a").eachText().get(9));
            for (int i = 1; i < index; i++) {
                parsingPage("http://www.sql.ru/forum/job-offers/" + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parsingPage(String href) {
        Document document;
        try {
            document = Jsoup.connect(href).get();
            Elements elementsForumTable = document.getElementsByAttributeValue("class", "forumTable");
            Elements elements = elementsForumTable.select("tr");
            for (int i = 4; i < elements.size(); i++) {
                Element element = elements.get(i);
                Elements urlAndText = element.getElementsByAttributeValue("class", "postslisttopic");
                String url = urlAndText.first().getElementsByTag("a").attr("href");
                String urlText = urlAndText.first().getElementsByTag("a").eachText().get(0);
                String date = element.getElementsByAttributeValue("class", "altCol").last().text();

                if (Pattern.compile("[j,J]ava\\s?(?!\\s?[s,S]cript)").matcher(urlText).find()) {

                    System.out.println(String.format("Вакансия: %s (%s) %s", urlText, date, url));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
