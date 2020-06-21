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
    private static final HashMap<Integer, CatalogCategorie> categories = new HashMap<>();
    private static final HashMap<Integer, CatalogItem> catalogItems = new HashMap<>();

    public HashMap<Integer, CatalogPage> getPages() {
        return pages;
    }

    public static void load() {

    }

    public static void loadPages() throws SQLException {
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_pages")) {
                    while(req.next()) {
                        pages.put(req.getInt("id"), new CatalogPage(req));
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(App.ERROR + "Unable to load catalog pages!");
        }
    }
}
