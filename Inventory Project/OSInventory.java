import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;



public class OSInventory {
    
    private static JFrame mainInventoryFrame;
    private static JMenuBar menuBar;
    private static JMenu fileMenu;
    private static JMenu editMenu;
    private static JMenu helpMenu;
    private static JTable inventoryTable;
    private static JPanel mainPanel;

    public OSInventory() {
        // Constructor
    }   

   

    public static void main(String[] args) {
        // Application entry point
        OSInventory main = new OSInventory();
        main.mainFrame();
        main.showMenu();
        main.fileMenu();
        main.editMenu();
        main.helpMenu();
    }

//---------------------------------------------------------------------------------------------------------


    //File Menu
    public void fileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
    }

    //Edit Menu
    public void editMenu() {
        editMenu = new JMenu("Edit");
        // Add edit menu items here
        menuBar.add(editMenu);
    }

    //Help Menu
    public void helpMenu() {
        helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainInventoryFrame, "OS Inventory Application\nVersion 1.0");
            }
        });     
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);
    }  

    //Main Frame
    public void mainFrame() {
        mainInventoryFrame = new JFrame("OS Inventory");
        mainInventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainInventoryFrame.setSize(800, 600);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        inventoryTable = new JTable(); // Placeholder for inventory table
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        mainPanel.add(scrollPane);
        mainInventoryFrame.add(mainPanel);
        mainInventoryFrame.setVisible(true);

        //JFrame to exit on close
        mainInventoryFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    //Menu Bar
    public void showMenu() {

        //Create Menu Bar
        final JMenuBar menuBar = new JMenuBar();

        //Add Menu Tabs to Menu Bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //Set Menu Bar to Frame
        mainInventoryFrame.setJMenuBar(menuBar);

        //Set Menu Bat Background Color
        menuBar.setBackground(Color.GRAY);

        //Remove Border around Menu Bar
        menuBar.setBorderPainted(false);

        //Set Menu Bar Opaque to true
        menuBar.setOpaque(true);

        
        mainInventoryFrame.setVisible(true);
    }   
//---------------------------------------------------------------------------------------------------------

}