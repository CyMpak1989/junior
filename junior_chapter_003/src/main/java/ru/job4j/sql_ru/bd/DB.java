package ru.job4j.sql_ru.bd;

import java.sql.Connection;

public class DB {
    private Connection connection = null;

    public DB(Connection connection) {
        this.connection = connection;
    }

    private void addData(){
        connection.prepareStatement();
    }
}
