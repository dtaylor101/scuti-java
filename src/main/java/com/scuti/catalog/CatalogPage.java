package com.scuti.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogPage {
    private final int id;
    private final String caption;
    private final int minRank;
    private final boolean visible;

    public CatalogPage(ResultSet req) throws SQLException {
        this.id = req.getInt("id");
        this.caption = req.getString("caption");
        this.minRank = req.getInt("min_rank");
        this.visible = req.getBoolean("visible");
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public int getMinRank() {
        return minRank;
    }

    public boolean isVisible() {
        return visible;
    }
}
