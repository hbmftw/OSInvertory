import java.awt.Color;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;


public class Example {

    private static JFrame myFrame;
    private JLabel dateTimeLabel;
    private JTextField myTextField;

    public Example() {
        // Constructor logic (if any) goes here
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.mainFrame();
        example.showMyMenu();
    }

    // Constructor for frame
    void mainFrame() {

        // initialize Spring Layout
        SpringLayout mySpringLayout = new SpringLayout();

        // set custom icon
        ImageIcon myImage = new ImageIcon("Ryan School Logo.png");

        // initialize frame
        myFrame = new JFrame("Example"); // add frame title

        myFrame.setSize(400, 400); // set frame size
        myFrame.setLayout(mySpringLayout); // set layout manager using spring layout manager 
        myFrame.setResizable(false); // set frame sesizable to false to prevent frame resizing
        myFrame.setIconImage(myImage.getImage()); // set image icon

        // initialize date time label
        dateTimeLabel = new JLabel("Date & Time");

        // initialize textfield
        myTextField = new JTextField("", 20);
        myTextField.setHorizontalAlignment(SwingConstants.CENTER); // Center text in textfield

        // add dateTimeLabel and myTextField to frame
        myFrame.add(dateTimeLabel);
        myFrame.add(myTextField);

        // JFrame to exit on close
        myFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0); // exit on close
            }
        });

        // make frame visible
        myFrame.setVisible(true);

        // layout constraints in JFrame using SpringLayout Class
        mySpringLayout.putConstraint(SpringLayout.EAST, dateTimeLabel, 100, SpringLayout.NORTH, myFrame);
        mySpringLayout.putConstraint(SpringLayout.WEST, myTextField, 50, SpringLayout.SOUTH, myFrame);

    }

    // Menu Elements method
    private void showMyMenu() {
        // Create Menu Bar
        final JMenuBar myMenuBar = new JMenuBar();

        // Create Menu Tab
        JMenu myMenu = new JMenu("MENU");

        // Create Menu Items ----------------------------------------
        // Date & Time
        JMenuItem dateMenuItem = new JMenuItem("DATE & TIME");
        dateMenuItem.setActionCommand(DateTimeItem.myDateTime());
        // Save Text Field
        JMenuItem saveMenuItem = new JMenuItem("SAVE");
        saveMenuItem.setActionCommand("save");
        // Panel color changer
        JMenuItem panelColorMenuItem = new JMenuItem("FRAME COLOR");
        panelColorMenuItem.setActionCommand(null);
        // Exit Program
        JMenuItem exitMenuItem = new JMenuItem("EXIT");
        exitMenuItem.setActionCommand("exit");

        // Action Listeners
        MenuItemListener menuItemListener = new MenuItemListener(); // Initialize action listener for menu items
        ChangePaneColorListener changePaneColorListener = new ChangePaneColorListener(); // Initialize action listener for changing background color
        SaveItemListener saveItemListener = new SaveItemListener(); // Initialize action listener for saving textfield data to txt file

        dateMenuItem.addActionListener(menuItemListener); // set menu action listener to "DATE & TIME" menu item
        saveMenuItem.addActionListener(saveItemListener); // set save action listener to "SAVE" menu item
        panelColorMenuItem.addActionListener(changePaneColorListener); // set changing background color to "FRAME COLOR" menu item
        exitMenuItem.addActionListener(menuItemListener); // set exit action listener to "EXIT" menu item

        // add menu items
        myMenu.add(dateMenuItem); // Add "DATE & TIME" to Menu
        myMenu.add(saveMenuItem); // Add "SAVE" to Menu
        myMenu.add(panelColorMenuItem); // ADD "FRAME COLOR" to Menu
        myMenu.addSeparator(); // Add line separator to menu to help prevent accidental exiting of application
        myMenu.add(exitMenuItem); // Add "Exit" to Menu

        // add menu to menuBar
        myMenuBar.add(myMenu);

        // now add to frame
        myFrame.setJMenuBar(myMenuBar);
        myFrame.setVisible(true); // set frame visible
    }

    // Class for returning current Date & Time
    static class DateTimeItem {
        public static String myDateTime() {
            String pattern = "MM/dd/yyyy HH:mm:ss"; // sets pattern format for Date & Time
            DateFormat myDateFormat = new SimpleDateFormat(pattern); // add pattern to date/time format
            java.util.Date currentDate = Calendar.getInstance().getTime(); // Get current date and time
            String myDateTime = myDateFormat.format(currentDate); // pass the current date and time to myDateTime variable
            return myDateTime; // return string date and time
        }
    }

    // Action Listener class that handles both myTextField and Exit from menu
    class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("exit".equals(e.getActionCommand())) {
                System.exit(0); // close on Exit in menu
            }
            myTextField.setText(e.getActionCommand()); // used for date & Time, calls on method class DateTimeItem
        }
    }

    // frame random color change action listener class
    class ChangePaneColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Declare string array to hold different hues of green in hex
            String[] bgColor = new String[] { "#e6ffee", "#ccffdd", "#b3ffcc", "#99ffbb", "#80ffaa", "#66ff99", "#4dff88", "#33ff77", "#1aff66", "#00ff55", "#00e64d", "#00cc44", "#00b33c" };
            Random random = new Random(); // initialize random number generator
            int i = random.nextInt(13); // set random from 0 to 12
            myFrame.getContentPane().setBackground(Color.decode(bgColor[i])); // change frame background color and decode hex to rgb
        }
    }

    // Action Listener class for saving textField items
    class SaveItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("save".equals(e.getActionCommand())) {
                FileOutputStream textOut; // create new fileoutputstream
                String lineSeparator = System.getProperty("line.separator");
                try {
                    textOut = new FileOutputStream("log.txt", true); // fileoutputstream to file log.txt
                    textOut.write(lineSeparator.getBytes()); // start new line
                    textOut.write(myTextField.getText().getBytes()); // write contents of textfield to file
                    textOut.close(); // close writer
                } catch (IOException e1) {
                }
            }
        }
    }
}
