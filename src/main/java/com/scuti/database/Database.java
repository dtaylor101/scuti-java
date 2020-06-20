package com.scuti.database;

import com.scuti.App;
import com.scuti.core.ConfigurationManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
    private static HikariDataSource database;
    public static void configure() {
        long millis = System.currentTimeMillis();
        try {
            System.out.println(App.LOADING + "Connection to database...");
            HikariConfig dbConfig = new HikariConfig();
            dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
            dbConfig.setJdbcUrl("jdbc:mysql://" + ConfigurationManager.dbhost + ":" + ConfigurationManager.dbport + "/" + ConfigurationManager.dbname + "");
            dbConfig.setUsername(ConfigurationManager.dbuser);
            dbConfig.setPassword(ConfigurationManager.dbpass);

            database = new HikariDataSource(dbConfig);
            System.out.println(App.SUCCESS + "Database manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
        } catch (Exception e) {
            System.out.println(App.ERROR + "Unable to connect to the database.");
        }
    }

    public static HikariDataSource getDB() {
        return database;
    }
}
