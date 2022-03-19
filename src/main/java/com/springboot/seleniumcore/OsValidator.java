package com.springboot.seleniumcore;

/**
 * OsValidator gets the os value.
 *
 */
public class OsValidator {

    private static String OS = System.getProperty("os.name").toLowerCase();

    static String getDeviceOs() {
        if (isWindows()) {
            return "windows";
        } else if (isMac()) {
            return "mac";
        } else if (isUnix()) {
            return "Unix";
        } else {
            return "invalid";
        }
    }

    private static boolean isWindows() {

        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() {

        return (OS.indexOf("mac") >= 0);
    }

    private static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 || OS.indexOf("linux") > 0);

    }
}
