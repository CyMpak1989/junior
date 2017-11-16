package ru.job4j.bank;

public class Account {
    public int value;
    public int requisites;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    public Account(int value, int requisites) {

        this.value = value;
        this.requisites = requisites;
    }
}
