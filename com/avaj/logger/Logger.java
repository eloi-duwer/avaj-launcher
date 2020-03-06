package com.avaj.logger;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static FileWriter writer = null;

    public static void initLogger(String fileName) throws IOException
    {
        Logger.writer = new FileWriter(fileName);
    }

    public static void log(String logString)
    {
        if (Logger.writer != null) {
            try {
                Logger.writer.append(logString + "\n");
            } catch (IOException e) {
                System.out.println("Error while logging to file:");
                e.printStackTrace();
            }
        }
        else
            System.out.println(logString);
    }

    public static void closeLog()
    {
        if (Logger.writer != null) {
            try {
                Logger.writer.close();
            } catch(IOException e) {}
        }
    }
}