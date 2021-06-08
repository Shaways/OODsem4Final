package se.kth.iv1350.seminar4.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * The <code>ErrorLogger</code> class handles logging of error reports when exceptions are caught
 * and the exception indicates that the program is not functioning as intended.
 * The error reports are logged to a file named errorlog.txt in the current directory.
 */
public class ErrorLogger {
    private PrintWriter logStream;

    /**
     * Creates a new instance of the <code>ErrorLogger</code>. If the file exists it is not deleted but instead
     * new error reports are appended to it.
     */
    public ErrorLogger(){
        try{
            logStream = new PrintWriter(new FileWriter("errorlog.txt", true), true);
        }
        catch(IOException e){
            System.out.println("Can not log errors.");
            e.printStackTrace();
        }
    }

    /**
     * Logs the thrown exception with additional information about the date and time when it was logged.
     * @param exception The thrown exception being logged.
     */
    public void logException(Exception exception) {
            StringBuilder error = new StringBuilder();
            error.append(createFormattedTime() + "\n");
            error.append("Exception was thrown: ");
            error.append(exception.getMessage());
            error.append("\nStack trace:");
            logStream.println(error);
            exception.printStackTrace(logStream);
    }

    private String createFormattedTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}