package ru.job4j.sql_ru.setting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 20.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class LoadSetting {
    private static final Logger LOG = LoggerFactory.getLogger(LoadSetting.class);
    public static final String CONFIG_FILE = "ConfigSQL_RU.properties";
    public static String URL;
    public static String USER;
    public static String PASSWORD;
    public static int YEAR;
    public static int MONTH;
    public static int DATE;

    public static void load(){
        final PropertiesParser ServerSettings = new PropertiesParser(CONFIG_FILE);

        URL = ServerSettings.getString("Url", "jdbc:postgresql://localhost:5432/sql_ru");
        USER = ServerSettings.getString("User", "postgres");
        PASSWORD = ServerSettings.getString("Password", "postgres");
        YEAR = Integer.parseInt(ServerSettings.getString("Year", "2007"));
        MONTH = Integer.parseInt(ServerSettings.getString("Month", "1"));
        DATE = Integer.parseInt(ServerSettings.getString("Date", "1"));

    }


}
