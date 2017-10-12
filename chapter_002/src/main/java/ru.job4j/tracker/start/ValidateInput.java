package ru.job4j.tracker.start;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Pleas  select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Pleas enter validate data again. ");
            }
        } while (invalid);

        return value;
    }
}
