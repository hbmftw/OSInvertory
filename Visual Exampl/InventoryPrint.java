import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;


public class InventoryPrint {

    public void printInventory() {
        //Create a new Printable Object
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        //Check for available printers
        if (printerJob == null) {
            System.out.println("No printers are available.");
            return;
        }

        //Associate the print job with our printable object
        printerJob.setPrintable(new InventoryPrintable());

        //Show the print dialog to the user and initiate printing if confirmed
        try {
            //Display the print dialog to the user
            if (printerJob.printDialog()) {
                //If the user confirms, proceed with printing
                printerJob.print();
            }
        } catch (PrinterException e) {
            System.err.println("Printing failed: " + e.getMessage());
        }

    }



}
