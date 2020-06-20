package com.scuti.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
    private static HikariDataSource database;
    public static void configure() {
        try {
            HikariConfig dbConfig = new HikariConfig();
            dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
            dbConfig.setJdbcUrl("jdbc:mysql://localhost:3306/scuti");
            dbConfig.setUsername("root");
            dbConfig.setPassword("");

            System.out.println("Connected to the database !");
            database = new HikariDataSource(dbConfig);
        } catch (Exception e) {
            System.out.println("Impossible de se connecter à la base de données !");
        }
    }

    public HikariDataSource getDB() {
        return database;
    }
}
