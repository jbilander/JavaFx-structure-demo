package com.example.common;

public class Util {
    
    public static final int APP_WIDTH = 640;
    public static final int APP_HEIGHT = 400;
    public static final String TITLE = "JavaFx-structure-demo";
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String JDBC_URL = "jdbc:sqlite:" + Util.USER_HOME + Util.FILE_SEPARATOR + "JavaFx-structure-demo.db";

    public static boolean isWindows() {
        return Util.OS.contains("win");
    }

    public static boolean isMac() {
        return Util.OS.contains("mac") || Util.OS.contains("darwin");
    }
}
