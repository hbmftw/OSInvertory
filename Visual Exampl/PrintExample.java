import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintExample {

    public static void main(String[] args) {
        // Create a new PrinterJob object
        PrinterJob job = PrinterJob.getPrinterJob();

        // Check if any printers are available
        if (job == null) {
            System.err.println("No printers found.");
            return;
        }
        
        // Associate the job with our custom Printable object
        job.setPrintable((Printable) new MyPrintable());

        // Display a print dialog for the user to select a printer and options
        boolean doPrint = job.printDialog();

        // If the user did not cancel the dialog, proceed with printing
        if (doPrint) {
            try {
                job.print();
                System.out.println("Print job started successfully.");
            } catch (PrinterException e) {
                System.err.println("Printing failed: " + e.getMessage());
            }
        } else {
            System.out.println("Print job cancelled by user.");
        }
    }
}