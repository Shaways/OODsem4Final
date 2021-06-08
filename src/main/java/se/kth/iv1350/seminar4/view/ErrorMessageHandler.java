package se.kth.iv1350.seminar4.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Handles displaying of error messages to the user.
 */
public class ErrorMessageHandler {
    /**
     * Prints a specified message to the user interface.
     * @param message The specified message to be printed.
     */
    void showErrorMessage(String message){
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append(createFormattedTime());
        errorMsg.append(" ERROR: ");
        errorMsg.append(message);
        System.out.println(errorMsg);
    }

    private String createFormattedTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}


