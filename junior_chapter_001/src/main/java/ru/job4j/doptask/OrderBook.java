package ru.job4j.doptask;

import org.xml.sax.SAXException;
import ru.job4j.doptask.handler.Handler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderBook {
    private Map<String, TreeMap<Integer, Order>> ordersMap = new HashMap<>();

    public void start() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        Handler handler = new Handler(ordersMap);
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("orders.xml"), handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OrderBook orderBook = new OrderBook();
        orderBook.start();
        System.out.println(orderBook.ordersMap.get("book-1").size());
        System.out.println(orderBook.ordersMap.get("book-2").size());
        System.out.println(orderBook.ordersMap.get("book-3").size());
    }
}
