package ru.job4j.profession;

/**
 * Class Engineer.
 *
 * @author CyMpak1989 (cympak2009@mail.ru)
 * @version 1.0
 * @since 26.09.2017
 */
public class Engineer extends Profession {
    /**
     * Method repair. Ремонтируем кран.
     */
    public void repair() {
        System.out.println("Инженер " + getName() + " ремонтирует кран.");
    }
}
