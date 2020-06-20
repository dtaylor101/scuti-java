package com.scuti;

import com.scuti.database.Database;

public class App
{
    // Colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    //Logo & version
    public final static String BUILD = "1.0-SNAPSHOT";
    public static final String version = "Scuti EMULATOR " + BUILD;
    private static final String logo =
            "\n" +
                    " ________  ________  ___  ___  _________  ___  _______   _____ ______   ___  ___     \n" +
                    "|\\   ____\\|\\   ____\\|\\  \\|\\  \\|\\___   ___\\\\  \\|\\  ___ \\ |\\   _ \\  _   \\|\\  \\|\\  \\    \n" +
                    "\\ \\  \\___|\\ \\  \\___|\\ \\  \\\\\\  \\|___ \\  \\_\\ \\  \\ \\   __/|\\ \\  \\\\\\__\\ \\  \\ \\  \\\\\\  \\   \n" +
                    " \\ \\_____  \\ \\  \\    \\ \\  \\\\\\  \\   \\ \\  \\ \\ \\  \\ \\  \\_|/_\\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\  \n" +
                    "  \\|____|\\  \\ \\  \\____\\ \\  \\\\\\  \\   \\ \\  \\ \\ \\  \\ \\  \\_|\\ \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \n" +
                    "    ____\\_\\  \\ \\_______\\ \\_______\\   \\ \\__\\ \\ \\__\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\\n" +
                    "   |\\_________\\|_______|\\|_______|    \\|__|  \\|__|\\|_______|\\|__|     \\|__|\\|_______|\n" +
                    "   \\|_________| " + ANSI_YELLOW + version + ANSI_WHITE + " - By Tig3r & Kozen\n" +

                    "                                                                                             ";
    public static void main(String[] args)
    {
        System.out.println( ANSI_YELLOW + logo );
        System.out.println( "Made with heart by Kozen and Tig3r" + ANSI_WHITE + " - " + ANSI_PURPLE + version);
        System.out.println("");
        System.out.println("");
        Database.configure();
        clearScreen();
        System.out.println( ANSI_WHITE + logo );
        System.out.println( ANSI_WHITE + "[" + ANSI_GREEN + "BUILD" + ANSI_WHITE + "] " + "Soon enft mhh...");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
