package ru.job4j.automat.menu;

import ru.job4j.automat.Automat;
import ru.job4j.automat.input.Input;


public class MenuAutoman {
    private Input input;
    private Automat automat;
    UserAction[] userActions = new UserAction[5];
    private int position = 0;

    public MenuAutoman(Input input, Automat automat) {
        this.input = input;
        this.automat = automat;
    }

    public void fillActions() {
        this.userActions[position++] = new AddCoins("Add Coins.", 0);
        this.userActions[position++] = new ShowAllCoins("Show all Coins.", 1);
        this.userActions[position++] = new showMoneyAutomat("Show money automat.", 2);
        this.userActions[position++] = new ToBuyCookies("To buy cookies. Цена 18 рублей.", 3);
        this.userActions[position++] = new ToGiveACoin("To give a coins. ", 4);
    }

    /**
     * Метод для отображения меню.
     */
    public void show() {
        for (UserAction action : this.userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.userActions[key].execute(this.input, this.automat);
    }
}
