package ru.job4j.javafx;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        for (int i = 0; i != table.length; i++) {
            if ((table[0][0].hasMarkX() && table[i][i].hasMarkX() && table[table.length - 1][table.length - 1].hasMarkX())
                    || (table[table.length - 1][i].hasMarkX() && table[i][table.length - 1].hasMarkX() && table[table.length - 2][table.length - 2].hasMarkX())
                    || (table[i][0].hasMarkX() && table[i][1].hasMarkX() && table[i][2].hasMarkX())
                    || (table[0][i].hasMarkX() && table[1][i].hasMarkX() && table[2][i].hasMarkX())) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinnerO() {
        for (int i = 0; i != table.length; i++) {
            if ((table[0][0].hasMarkO() && table[i][i].hasMarkO() && table[table.length - 1][table.length - 1].hasMarkO())
                    || (table[table.length - 1][i].hasMarkO() && table[i][table.length - 1].hasMarkO() && table[table.length - 2][table.length - 2].hasMarkO())
                    || (table[i][0].hasMarkO() && table[i][1].hasMarkO() && table[i][2].hasMarkO())
                    || (table[0][i].hasMarkO() && table[1][i].hasMarkO() && table[2][i].hasMarkO())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasGap() {
        return true;
    }
}
