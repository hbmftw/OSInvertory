import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class printObject implements Printable {

    @Override
    //Method is called by the printing system to render each page
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       // When only one page, stop after printing the page
       if (pageIndex > 0) {
        return NO_SUCH_PAGE;
       }

       // Cast the Graphics object to Graphics2d for more advanced drawing
       Graphics2D g2d = (Graphics2D) graphics;

       //Translate the drawing origin to the page's imageable area
       //This avoids content being clipped by unprintable margins
       g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

       // Now, draw your content
       g2d.drawString("Hello, Printer!", 100, 100);

       // Tell the printing system that page was printed
       return PAGE_EXISTS;

    }
    
}