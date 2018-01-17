package ru.job4j.doptask.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.job4j.doptask.Order;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Handler extends DefaultHandler {
    private Map<String, TreeMap<Integer, Order>> ordersMap;
    private static final String ADD_ORDER = "AddOrder";
    private static final String DELETE_ORDER = "DeleteOrder";
    Date start;
    Date end;

    public Handler(Map<String, TreeMap<Integer, Order>> ordersMap) {
        this.ordersMap = ordersMap;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing!");
        start = new Date();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing!");
        end = new Date();
        System.out.println(end.getSeconds() - start.getSeconds() + " sec...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (ADD_ORDER.equals(qName)) {
            Order order = new Order();
            order.setBook(attributes.getValue("book"));
            order.setOperation(attributes.getValue("operation"));
            order.setPrice(Float.valueOf(attributes.getValue("price")));
            order.setVolume(Integer.parseInt(attributes.getValue("volume")));
            order.setOrderId(Integer.valueOf(attributes.getValue("orderId")));
            ordersMap.putIfAbsent(order.getBook(), new TreeMap<>());
            TreeMap<Integer, Order> treeMap = ordersMap.get(order.getBook());
            treeMap.put(order.getOrderId(), order);
        } else if (DELETE_ORDER.equals(qName)) {
            TreeMap<Integer, Order> treeMap = ordersMap.get(attributes.getValue("book"));
            treeMap.remove(Integer.parseInt(attributes.getValue("orderId")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }
}
