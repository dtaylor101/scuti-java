package com.scuti.core;

import org.ini4j.*;
import com.scuti.App;
import java.io.File;


public class ConfigurationManager {
    public static String dbhost;
    public static String dbport;
    public static String dbname;
    public static String dbuser;
    public static String dbpass;
    public static void getConfiguration() {
        long millis = System.currentTimeMillis();
        try{
            System.out.println(App.LOADING + "Loading configuration file...");
            Wini ini = new Wini(new File("config.ini"));
            dbhost = ini.get("database", "dbhost");
            dbport = ini.get("database", "dbport");
            dbname = ini.get("database", "dbname");
            dbuser = ini.get("database", "dbuser");
            dbpass = ini.get("database", "dbpass");


        }catch(Exception e){
            System.err.println(App.ERROR + e.getMessage());
            System.exit(0);
        }
        System.out.println(App.SUCCESS + "Configuration manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }
}
