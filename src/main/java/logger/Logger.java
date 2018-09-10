package logger;

import java.io.*;

import static data.Errors.LOGGER_INITIALIZE_ERROR;

/**
 * contains methods for writing the log file
 *
 * @author Robert
 */
public class Logger {
    /**
     * log file name
     */
    private static final String logFile = "errorTreeLog.txt";
    /**
     * path to log file
     */
    private static final String logFilePath = "/home/robert";
    /**
     * object used to write in the log file
     */
    private static PrintWriter printWriter;

    /**
     * default logger initialization
     * @throws Exception if the log file could be prepared
     */
    private static void initialize() throws Exception {
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath+"/"+logFile, true)));
    }

    /**
     * logger initialization
     * @param fullLogPath path to log file, including log file name
     * @param append if true, the log file will not be overwritten
     * @throws Exception if the log file could not be prepared
     */
    public static void initialize(String fullLogPath, boolean append) throws Exception {
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fullLogPath, append)));
    }

    /**
     * logger initialization
     * @param outputStream outputStream used instead of a log file
     */
    public static void initialize(OutputStream outputStream) {
        printWriter = new PrintWriter(outputStream);
    }

    /**
     * logger initialization
     * @param file file object used for writing the log
     * @throws Exception if the log file could not be prepared
     */
    public static void initialize(File file) throws Exception {
        printWriter = new PrintWriter(file);
    }

    /**
     * writes to the log
     * @param message message to be written to the log file
     */
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

    /**
     * writes an exception to the log
     * @param e exception to be written to the log
     */
    public static void printException(Exception e) {
        if (e == null)
            return;
        e.printStackTrace(printWriter);
        printWriter.flush();
    }
}
