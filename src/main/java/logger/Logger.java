package logger;

import java.io.*;

import static data.Errors.LOGGER_INITIALIZE_ERROR;

public class Logger {
    private static PrintWriter printWriter;
    private static final String logFile = "errorTreeLog.txt";
    private static final String logFilePath = "/home/robert";

    private static void initialize() throws Exception {
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath+"/"+logFile, true)));
    }

    public static void initialize(String fullLogPath, boolean append) throws Exception {
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fullLogPath, append)));
    }

    public static void initialize(OutputStream outputStream) {
        printWriter = new PrintWriter(outputStream);
    }

    public static void initialize(File file) throws Exception {
        printWriter = new PrintWriter(file);
    }

    public static void log(String message) {
        if (printWriter == null) {
            try {
                initialize();
            }catch (Exception e) {
                System.out.println(LOGGER_INITIALIZE_ERROR);
                e.printStackTrace();
                return;
            }
        }
        printWriter.println(message);
        printWriter.flush();
    }

    public static void printException(Exception e) {
        if (e == null)
            return;
        e.printStackTrace(printWriter);
        printWriter.flush();
    }
}
