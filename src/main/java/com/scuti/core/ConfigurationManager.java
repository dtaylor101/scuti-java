package com.scuti.core;

import org.ini4j.*;
import com.scuti.App;
import java.io.File;

public class ConfigurationManager {
    public static void getConfiguration() {
        try{
            System.out.println(App.LOADING + "Loading configuration file...");
            Wini ini = new Wini(new File("config.ini"));
            String testcc = ini.get("test", "cc");


            System.out.println(App.SUCCESS + "Configuration manager -> OK!");
        }catch(Exception e){
            System.err.println(App.ERROR + e.getMessage());
        }
    }
}
