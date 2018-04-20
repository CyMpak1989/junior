package ru.job4j.sql_ru;

import ru.job4j.sql_ru.bd.ConnectionSQL;
import ru.job4j.sql_ru.bd.DataBase;
import ru.job4j.sql_ru.items.Url;
import ru.job4j.sql_ru.setting.LoadSetting;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Parser {
    private ArrayBlockingQueue<Url> urlQueue = new ArrayBlockingQueue<Url>(5000);

    public ArrayBlockingQueue<Url> getQueue() {
        return urlQueue;
    }

    public static void main(String[] args) {
        LoadSetting.load();
        ConnectionSQL connectionSQL = new ConnectionSQL(LoadSetting.URL, LoadSetting.USER, LoadSetting.PASSWORD);
        DataBase dataBase = new DataBase(connectionSQL.getConnection());
        Parser parser = new Parser();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        service.scheduleWithFixedDelay(new PageScanner(parser.getQueue()), 0, 1, TimeUnit.DAYS);
        service.scheduleWithFixedDelay(new AdvertScanner(parser.getQueue(), dataBase), 0, 1, TimeUnit.DAYS);
        service.scheduleWithFixedDelay(new AdvertScanner(parser.getQueue(), dataBase), 0, 1, TimeUnit.DAYS);
        service.scheduleWithFixedDelay(new AdvertScanner(parser.getQueue(), dataBase), 0, 1, TimeUnit.DAYS);
        service.scheduleWithFixedDelay(new AdvertScanner(parser.getQueue(), dataBase), 0, 1, TimeUnit.DAYS);
    }
}
