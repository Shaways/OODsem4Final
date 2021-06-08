package se.kth.iv1350.seminar4.startup;

import se.kth.iv1350.seminar4.Integration.SystemCreator;
import se.kth.iv1350.seminar4.controller.Controller;
import se.kth.iv1350.seminar4.view.View;

/**
 *
 * Starts the entire application. Contains the main method used to start the application.
 */
public class Main {

    /**
     * The main method used to start the application.
     *
     * @param args The program does not take any command line parameters.
     */
    public static void main(String[] args){
        SystemCreator creator = new SystemCreator();
        Controller contr = new Controller(creator);
        View view = new View(contr);
        view.fakeExecution();
    }
}
