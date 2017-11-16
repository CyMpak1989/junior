package ru.job4j.bank;

/**
 *
 */
public class Account {
    /**
     *
     */
    public double value;
    /**
     *
     */
    public int requisites;

    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public int getRequisites() {
        return requisites;
    }

    /**
     *
     * @param requisites
     */
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    /**
     *
     * @param value
     * @param requisites
     */
    public Account(int value, int requisites) {

        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) return false;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }
}
