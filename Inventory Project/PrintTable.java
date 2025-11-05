import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintTable {

    public void print_Page() {
        //Create new printable object
        PrinterJob printJob = PrinterJob.getPrinterJob();

        //Check for available printers
        if (printJob == null) {
            System.out.println("No Printers Are Available.");
            return;
        }

        //Associate the print job with our printable object
        printJob.setPrintable(new printObject());

        //Show the print dialog to the user and initiate printing if confirmed
        try {
            //Display the print dialog to the user
            if (printJob.printDialog()) {
                //If the user confirms, proceed with printing
                printJob.print();
            }
        }
        catch (PrinterException e) {
            System.err.println("Printing Failed: " + e.getMessage());
        }
    }
    
}
