package com.scuti.catalog;

import com.scuti.App;
import com.scuti.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class CatalogManager {
    private static final HashMap<Integer, CatalogPage> pages = new HashMap<>();
    private static final HashMap<Integer, CatalogCategory> categories = new HashMap<>();
    private static final HashMap<Integer, CatalogItem> catalogItems = new HashMap<>();

    public HashMap<Integer, CatalogPage> getPages() {
        return pages;
    }

    public static void load() throws SQLException {
        loadPages();
        //loadItems();
    }

    /*public static void loadItems() throws SQLException {
        System.out.println(App.LOADING + "Loading catalog items...");
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_items")) {
                    while(req.next()) {
                        // TODO: create item class + database table corresponding!
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(App.ERROR + "Unable to load catalog items!");
        }
    }*/

    public static void loadPages() throws SQLException {
        System.out.println(App.LOADING + "Loading catalog pages...");
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_pages")) {
                    while(req.next()) {
                        pages.put(req.getInt("id"), new CatalogPage(req));
                        System.out.println(App.SUCCESS + "Catalog pages -> OK!");
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(App.ERROR + "Unable to load catalog pages!");
        }
    }
}
