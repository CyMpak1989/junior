package ru.job4j.automat;

import ru.job4j.automat.input.ConsoleInput;
import ru.job4j.automat.input.Input;
import ru.job4j.automat.menu.MenuAutoman;

/**
 * Class StartUI.
 */
public class StartUI {
    /**
     * Переменная типа Input.
     */
    private Input input;
    /**
     * Переменная типа Automat.
     */
    private Automat automat;

    /**
     * Конструктор StartUI.
     * @param input принимаем ссылку на объект Input.
     * @param automat принимаем ссылку на объект Automat.
     */
    public StartUI(Input input, Automat automat) {
        this.input = input;
        this.automat = automat;
    }

    /**
     * Метод init.
     */
    private void init() {
        MenuAutoman menuAutoman = new MenuAutoman(input, automat);
        menuAutoman.fillActions();
        do {
            menuAutoman.show();
            menuAutoman.select(Integer.valueOf(input.ask("Select: ")));
        } while (!"y".equals(input.ask("Exit? (y/n): ")));
    }

    /**
     * Точка входа в программу.
     * @param args принимаем массив параметров.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Automat()).init();
    }


}
