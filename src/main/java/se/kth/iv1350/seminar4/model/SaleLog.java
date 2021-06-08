package se.kth.iv1350.seminar4.model;

import java.util.ArrayList;
import java.util.List;


/**
 * <code>SaleLog</code> handles logging of finished sales.
 */
public class SaleLog {
    private List<Sale> saleLog;

    /**
     * Creates an instance of the class with an empty list of <code>Sale</code> objects.
     */
    public SaleLog(){
        saleLog = new ArrayList<>();
    }

    /**
     * Logs a sale by adding it to the list.
     *
     * @param saleBeingLogged The sale being added to the sale log.
     */
    public void logSale(Sale saleBeingLogged){
        saleLog.add(saleBeingLogged);
    }
}