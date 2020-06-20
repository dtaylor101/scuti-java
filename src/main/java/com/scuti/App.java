package com.scuti;

public class App
{
    // Colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    //Logo & version
    public final static String BUILD = "0.0.1a";
    public static final String version = "Scuti EMULATOR" + BUILD;
    private static final String logo =
            "\n" +
                    "   SSSSSSSSSSSSSSS                                              tttt            iiii  \n" +
                    " SS:::::::::::::::S                                          ttt:::t           i::::i\n" +
                    "S:::::SSSSSS::::::S                                          t:::::t            iiii  \n" +
                    "S:::::S     SSSSSSS                                          t:::::t                  \n" +
                    "S:::::S                ccccccccccccccccuuuuuu    uuuuuuttttttt:::::ttttttt    iiiiiii \n" +
                    "S:::::S              cc:::::::::::::::cu::::u    u::::ut:::::::::::::::::t    i:::::i \n" +
                    " S::::SSSS          c:::::::::::::::::cu::::u    u::::ut:::::::::::::::::t     i::::i \n" +
                    "  SS::::::SSSSS    c:::::::cccccc:::::cu::::u    u::::utttttt:::::::tttttt     i::::i \n" +
                    "    SSS::::::::SS  c::::::c     cccccccu::::u    u::::u      t:::::t           i::::i \n" +
                    "       SSSSSS::::S c:::::c             u::::u    u::::u      t:::::t           i::::i \n" +
                    "            S:::::Sc:::::c             u::::u    u::::u      t:::::t           i::::i \n" +
                    "            S:::::Sc::::::c     cccccccu:::::uuuu:::::u      t:::::t    tttttt i::::i \n" +
                    "SSSSSSS     S:::::Sc:::::::cccccc:::::cu:::::::::::::::uu    t::::::tttt:::::ti::::::i\n" +
                    "S::::::SSSSSS:::::S c:::::::::::::::::c u:::::::::::::::u    tt::::::::::::::ti::::::i\n" +
                    "S:::::::::::::::SS   cc:::::::::::::::c  uu::::::::uu:::u      tt:::::::::::tti::::::i\n" +
                    " SSSSSSSSSSSSSSS       cccccccccccccccc    uuuuuuuu  uuuu        ttttttttttt  iiiiiiii\n" +

                    "                                                                                             ";
    public static void main( String[] args )
    {

        System.out.println( ANSI_YELLOW + logo );
        System.out.println( "Made with heart by Kozen and Tig3r" + ANSI_WHITE + " - " + ANSI_PURPLE + version);
    }
}
