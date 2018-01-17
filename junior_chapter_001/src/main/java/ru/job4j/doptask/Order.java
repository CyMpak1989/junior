package ru.job4j.doptask;

public class Order implements Comparable<Order> {
    private String book;
    private String operation;
    private Float price;
    private int volume;
    private int orderId;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int compareTo(Order o) {
        int temp = o.operation.compareTo(this.operation);
        if (temp == 0) {
            if (this.operation.equals("BUY")) {
                if ((o.getPrice() - this.getPrice()) > 0) {
                    temp = 1;
                } else {
                    temp = -1;
                }
            } else {
                if ((o.getPrice() - this.getPrice()) < 0) {
                    temp = 1;
                } else {
                    temp = -1;
                }
            }
        }
        return temp;
    }
}
