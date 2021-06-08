package se.kth.iv1350.seminar4.Integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import se.kth.iv1350.seminar4.model.PaymentObserver;
import se.kth.iv1350.seminar4.util.Amount;
import se.kth.iv1350.seminar4.util.ErrorLogger;

/**
 * <code>TotalRevenueFileOutput</code> will print the total revenue since the program was started to a file,
 * every time a sale has been paid for. The file is named totalRevenue.txt.
 */
public class TotalRevenueFileOutput implements PaymentObserver {
    private Amount totalRevenue;
    private PrintWriter logStream;
    private ErrorLogger errorLogger = new ErrorLogger();

    /**
     * Creates a new instance of the <code>TotalRevenueFileOutput</code>. If the file exists it will be overwritten.
     */
    public TotalRevenueFileOutput(){
        try{
            logStream = new PrintWriter(new FileWriter("totalRevenue.txt"), true);
            totalRevenue = new Amount();
        }
        catch(IOException e){
            System.out.println("Can not log total revenue.");
            errorLogger.logException(e);
        }
    }

    /**
     * Updates the total revenue and prints it to the file.
     * @param revenue The amount to be added to the total revenue.
     */
    @Override
    public void updateTotal(Amount revenue){
        totalRevenue = totalRevenue.plus(revenue);
        logStream.println(LocalDateTime.now());
        logStream.println("TOTAL REVENUE");
        logStream.println(totalRevenue);
    }
}