package com.scuti.networking.gameserver;

import com.scuti.App;
import com.scuti.database.Database;
import com.scuti.networking.Server;
import com.scuti.catalog.*;
import com.scuti.rooms.RoomManager;
import com.scuti.networking.*;
import com.scuti.rooms.Room;
import jdk.nashorn.internal.parser.JSONParser;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.*;

@WebSocket
public class GameServer {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws SQLException {
        String username = "User" + Server.nextUserNumber++;
        System.out.println(username + " joined the server");
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_pages WHERE visible = '1' AND parent_id = '-1' ORDER BY LENGTH(order_num)")) {
                    while(req.next()) {
                        user.getRemote().sendString(String.valueOf(new JSONObject()
                                .put("catalogTabCaption", req.getString("caption"))
                                .put("catalogTabId", req.getInt("id"))
                        ));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(App.ERROR + "ptit pb enft soon is back");
            System.exit(0);
        }
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        System.out.println("Somebody left :(");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        String[] messagesplit = message.split(";@-;");
        if(messagesplit[0].equals("openCatalog")) {
            System.out.println(message);
            try {
                user.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("canOpenCatalog", "true")
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(messagesplit[0].equals("openNavigator")) {
            System.out.println(message);
            try {
                user.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("canOpenNavigator", "true")
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(messagesplit[0].equals("openCatalogPage")) {
            System.out.println("Page id: " + messagesplit[1]);
            int pageId = Integer.parseInt(messagesplit[1]);
            try(Connection connection = Database.getDB().getConnection()) {
                try(Statement statement = connection.createStatement()) {
                    try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_pages WHERE id = " + pageId + "")) {
                        while(req.next()) {
                            int parent_id = req.getInt("parent_id");
                            String page_layout = req.getString("page_layout");
                            String page_caption = req.getString("caption");
                            String icon_image = req.getString("icon_image");
                            String page_headline = req.getString("page_headline");
                            String page_text1 = req.getString("page_text1");
                            String page_text2 = req.getString("page_text2");
                            String page_text_details = req.getString("page_text_details");
                            String page_teaser = req.getString("page_teaser");
                            if(parent_id != -1) {
                                user.getRemote().sendString(String.valueOf(new JSONObject()
                                        .put("pageLayout", page_layout)
                                        .put("pageId", pageId)
                                        .put("pageCaption", page_caption)
                                        .put("pageIcon", icon_image)
                                        .put("pageHeadline", page_headline)
                                        .put("pageText1", page_text1)
                                        .put("pageText2", page_text2)
                                        .put("pageTextDetails", page_text_details)
                                        .put("pageTeaser", page_teaser)
                                ));
                            } else if(parent_id == -1) {
                                user.getRemote().sendString(String.valueOf(new JSONObject()
                                        .put("pageLayout", page_layout)
                                        .put("pageId", pageId)
                                        .put("pageParentId", -1)
                                        .put("pageCaption", page_caption)
                                        .put("pageIcon", icon_image)
                                        .put("pageHeadline", page_headline)
                                        .put("pageText1", page_text1)
                                        .put("pageText2", page_text2)
                                        .put("pageTextDetails", page_text_details)
                                        .put("pageTeaser", page_teaser)
                                ));
                                try(Connection connectionn = Database.getDB().getConnection()) {
                                    try (Statement statementt = connectionn.createStatement()) {
                                        try (ResultSet req2 = statementt.executeQuery("SELECT * FROM catalog_pages WHERE parent_id = " + pageId + " AND visible = '1'")) {
                                            while (req2.next()) {
                                                int pageId2 = req2.getInt("id");

                                                try(Connection connectionnn = Database.getDB().getConnection()) {
                                                    try (Statement statementtt = connectionnn.createStatement()) {
                                                        try (ResultSet req3 = statementtt.executeQuery("SELECT * FROM catalog_pages WHERE parent_id = " + pageId2 + " AND visible = '1'")) {
                                                            if(!req3.first() && !req3.next()) {
                                                                System.out.println(App.ERROR + "Soon iz bak tkt");
                                                                user.getRemote().sendString(String.valueOf(new JSONObject()
                                                                        .put("catalogLeftSub", "false")
                                                                        .put("catalogLeftCaption", req2.getString("caption"))
                                                                        .put("catalogLeftId", req2.getInt("id"))
                                                                        .put("catalogLeftIcon", req2.getInt("icon_image"))
                                                                ));
                                                            } else if(req3 != null) {
                                                                    System.out.println(App.SUCCESS + "cccccccccc");
                                                                    user.getRemote().sendString(String.valueOf(new JSONObject()
                                                                            .put("catalogLeftSub", "true")
                                                                            .put("catalogLeftCaption", req2.getString("caption"))
                                                                            .put("catalogLeftId", req2.getInt("id"))
                                                                            .put("catalogLeftIcon", req2.getInt("icon_image"))
                                                                    ));
                                                                try(Connection connectionnnn = Database.getDB().getConnection()) {
                                                                    try(Statement statementttt = connectionnnn.createStatement()) {
                                                                        try(ResultSet req4 = statementttt.executeQuery("SELECT * FROM catalog_pages WHERE parent_id = " + pageId2 + " AND visible = '1'")) {
                                                                            while(req4.next()) {
                                                                                user.getRemote().sendString(String.valueOf(new JSONObject()
                                                                                        .put("catalogLeftSubCaption", req4.getString("caption"))
                                                                                        .put("catalogLeftSubId", req4.getInt("id"))
                                                                                        .put("catalogLeftSubParentId", req4.getInt("parent_id"))
                                                                                        .put("catalogLeftSubIcon", req4.getInt("icon_image"))
                                                                                ));
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (Exception e) {
                                                                    System.out.println(App.ERROR + "ptit pb enft soon is back");
                                                                    System.exit(0);
                                                                }

                                                            }
                                                        }
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println(App.ERROR + "Page " + pageId + " not found! :(");
                                                    System.exit(0);
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println(App.ERROR + "Page " + pageId + " not found! :(");
                                    System.exit(0);
                                }
                            } else {
                                user.getRemote().sendString(String.valueOf(new JSONObject()
                                        .put("pageLayout", page_layout)
                                        .put("pageId", pageId)
                                        .put("pageCaption", page_caption)
                                        .put("pageIcon", icon_image)
                                        .put("pageHeadline", page_headline)
                                        .put("pageText1", page_text1)
                                        .put("pageText2", page_text2)
                                        .put("pageTextDetails", page_text_details)
                                        .put("pageTeaser", page_teaser)
                                ));
                                try(Connection connectionn = Database.getDB().getConnection()) {
                                    try (Statement statementt = connectionn.createStatement()) {
                                        try (ResultSet req2 = statementt.executeQuery("SELECT * FROM catalog_pages WHERE parent_id = " + pageId + " AND visible = '1'")) {
                                            while (req2.next()) {
                                                user.getRemote().sendString(String.valueOf(new JSONObject()
                                                ));
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println(App.ERROR + "Page " + pageId + " not found! :(");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(App.ERROR + "Page " + pageId + " not found!");
                System.exit(0);
            }
        }
    }

}
