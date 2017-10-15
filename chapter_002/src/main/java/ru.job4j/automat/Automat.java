package ru.job4j.automat;

public class Automat {
    private int[] userCoins = new int[10];
    private int position = 0;
    private int ten = 10;
    private int five = 10;
    private int two = 10;
    private int one = 10;
    private int summaInput = 0;

    public void makeMoney(int money) {
        this.userCoins[position++] = money;
    }

    public int getSummaInput() {
        return summaInput;
    }

    public void insertedMoney() {
        for (int coin : this.userCoins) {
            this.summaInput = this.summaInput + coin;
            if (coin == 10) {
                this.ten++;
            } else if (coin == 5) {
                this.five++;
            } else if (coin == 2) {
                this.two++;
            } else if (coin == 1) {
                this.one++;
            }
        }
        resetArray();
    }

    public String info() {
        return String.format("Десять: %s. Пять: %s. Два: %s. Один: %s", ten, five, two, one);
    }

    public void toBuyCookies() {
        if (summaInput >= 18) {
            summaInput = summaInput - 18;
            System.out.println("Вы купили печенье. У вас осталось: " + summaInput);
        } else {
            System.out.println("У вас не хватает манет: " + summaInput);
        }
    }

    public void toGiveACoin() {
        resetArray();
        while (this.summaInput != 0) {
            if ((this.summaInput / 10) >= 1) {
                userCoins[position++] = 10;
                this.summaInput = this.summaInput - 10;
                ten--;
            } else if ((this.summaInput / 5) >= 1) {
                userCoins[position++] = 5;
                this.summaInput = this.summaInput - 5;
                five--;
            } else if ((this.summaInput / 2) >= 1) {
                userCoins[position++] = 2;
                this.summaInput = this.summaInput - 2;
                two--;
            } else if ((this.summaInput / 1) >= 1) {
                userCoins[position++] = 1;
                this.summaInput = this.summaInput - 1;
                one--;
            }
        }
        for (int coin : userCoins) {
            if (coin != 0) {
                System.out.println("Ваша сдача: " + coin);
            }
        }
        resetArray();
    }

    public void resetArray() {
        for (int i = 0; i < userCoins.length; i++) {
            userCoins[i] = 0;
        }
        position = 0;
    }
}
