package com.scuti.database;

import com.scuti.App;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
    private static HikariDataSource database;
    public static void configure() {
        try {
            System.out.println(App.LOADING + "Connection to database...");
            HikariConfig dbConfig = new HikariConfig();
            dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
            dbConfig.setJdbcUrl("jdbc:mysql://localhost:3306/scuti");
            dbConfig.setUsername("root");
            dbConfig.setPassword("");

            System.out.println(App.SUCCESS + "Database manager -> OK!");
            database = new HikariDataSource(dbConfig);
        } catch (Exception e) {
            System.out.println(App.ERROR + "Unable to connect to the database.");
        }
    }

    public HikariDataSource getDB() {
        return database;
    }
}
