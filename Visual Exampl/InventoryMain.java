import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;


public class InventoryMain {
	
	private static JFrame myFrame;
	private database_connect database_connect;
	private InventoryPrint inventoryPrint;
	private dbFrame dbFrame;
	private static javax.swing.JPanel newPanel;

	public InventoryMain(){}
	
	//Java main function
	public static void main(String[] args) {
		InventoryMain main = new InventoryMain();
		main.mainFrame();
		main.showMyMenu();
		main.fileMenu();
		main.editMenu();
		main.helpMenu();
	}
	
	//Frame Constructor
	void mainFrame() {

		//initialize Spring Layout
		SpringLayout mainSpringLayout = new SpringLayout();
		
		// Intialize Frame
		myFrame = new JFrame("Inventory System"); //Frame title
		myFrame.setSize(400, 400); //Set Frame Size
		myFrame.setLayout(mainSpringLayout); //Set Layout Manager Using Spring Layout Manager
		myFrame.setResizable(true); //Set Frame Resizable to True
		myFrame.getContentPane().setBackground(Color.LIGHT_GRAY); //Set Frame Background Color
		
		//JFrame to exit on close
		myFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
			System.exit(0);
			}
		});
		
		//Make Frame Visable
		myFrame.setVisible(true);

	}	
	
	//Menu Bar Constructor
	void showMyMenu() {

		//Create Menu Bar
		final JMenuBar mainMenuBar = new JMenuBar();

		//Add Menu Tabs to Menu Bar
		mainMenuBar.add(fileMenu());
		mainMenuBar.add(editMenu());
		
		mainMenuBar.add(helpMenu());

		//Set the menu bar to the frame
		myFrame.setJMenuBar(mainMenuBar);

		//Set the menu bar background color
		mainMenuBar.setBackground(Color.GRAY);
		mainMenuBar.setBorderPainted(false); //Remove border around menu bar
		mainMenuBar.setOpaque(true); //Set menu bar to opaque

		//Set the menu bar to the frame
		myFrame.setJMenuBar(mainMenuBar);
		myFrame.setVisible(true);


	}
	
	//FILE menu items function
	private JMenu fileMenu() {
		//------------FILE MENU ITEMS----------------

		JMenu fileMenu = new JMenu("FILE");

		//Open Database menu item
		JMenuItem openDataBase = new JMenuItem("Open Database");
		openDataBase.setActionCommand("openDB");

		//Backup Database menu item
		JMenuItem backupDataBase = new JMenuItem("Backup Database");
		backupDataBase.setActionCommand("backupDB");

		//Print Menu item to print current frame
		JMenuItem printItem = new JMenuItem("Print");
		printItem.setActionCommand("print");

		//Exit menu item with action command "exit"
		JMenuItem exitInventoryProgram = new JMenuItem("Exit");
		exitInventoryProgram.setActionCommand("exit");

		//Add action listeners to file menu items
		openDataBase.addActionListener(new openDataBaseListener());
		backupDataBase.addActionListener(new backupDataBaseListener());
		printItem.addActionListener(new printItemListener());
		exitInventoryProgram.addActionListener(new exitInventoryProgramListener());


		// Add menu items to the FILE menu
		fileMenu.add(openDataBase);
		fileMenu.add(backupDataBase);
		fileMenu.add(printItem);
		fileMenu.add(exitInventoryProgram);

		return fileMenu;
		
	}

	//EDIT menu items function
	private JMenu editMenu() {
		//------------EDIT MENU ITEMS----------------

		JMenu editMenu = new JMenu("EDIT");

		//EDIT items
		JMenuItem addItem = new JMenuItem("Add Item");
		addItem.setActionCommand("addItem");

		//Delete items
		JMenuItem deleteItem = new JMenuItem("Delete Item");
		deleteItem.setActionCommand("deleteItem");

		//Modify items
		JMenuItem modifyItem = new JMenuItem("Modify Item");
		modifyItem.setActionCommand("modifyItem");

		//Add action listeners to EDIT menu items
		addItem.addActionListener(new addItemListener());
		deleteItem.addActionListener(new deleteItemListener());
		modifyItem.addActionListener(new modifyItemListener());	
		
		// Add menu items to the EDIT menu
		editMenu.add(addItem);
		editMenu.add(deleteItem);
		editMenu.add(modifyItem);
	
		return editMenu;
	}


//------------HELP MENU ITEMS----------------
	//HELP menu items function returns HELP menu object	
	private JMenu helpMenu() {
		
		JMenu helpMenu = new JMenu("HELP");

		//About Program menu item
		JMenuItem aboutProgram = new JMenuItem("About Program");
		aboutProgram.setActionCommand("aboutProgram");

		//Contact Support menu item
		JMenuItem contactSupport = new JMenuItem("Contact Support");
		contactSupport.setActionCommand("contactSupport");

		//Check for Updates menu item
		JMenuItem checkForUpdates = new JMenuItem("Check for Updates");
		checkForUpdates.setActionCommand("checkForUpdates");

		//Add action listeners to HELP menu items
		aboutProgram.addActionListener(new aboutProgramListener());
		contactSupport.addActionListener(new contactSupportListener());
		checkForUpdates.addActionListener(new checkForUpdatesListener());

		// Add menu items to the HELP menu
		helpMenu.add(aboutProgram);
		helpMenu.add(contactSupport);
		helpMenu.add(checkForUpdates);

		return helpMenu;
	}

	//Action Listeners for menu items

	//File Menu Action Listeners------------------------
	class openDataBaseListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("Open Database Clicked");
			//database_connect.main(null);
			JPanel dataPanel = createDataPanel();
			myFrame.getContentPane().removeAll();
			myFrame.getContentPane().add(dataPanel);
			myFrame.revalidate();
			myFrame.repaint();
			
		}
	}
	class backupDataBaseListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("Backup Database Clicked");
			
		}
	}
	class printItemListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("Print Clicked");
			InventoryPrint inventoryPrint = new InventoryPrint();
			inventoryPrint.printInventory();
		}
	}
	class exitInventoryProgramListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("Exit Clicked");
			System.exit(0);
		}
	}


	//Edit Menu Action Listeners------------------------
	class addItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Add Item Clicked");
		}
	}
	class deleteItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Delete Item Clicked");
		}
	}
	class modifyItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Modify Item Clicked");
		}
	}
	//Help Menu Action Listeners------------------------
	class aboutProgramListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("About Program Clicked");
		}
	}
	class contactSupportListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Contact Support Clicked");
		}
	}
	class checkForUpdatesListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Check for Updates Clicked");
		}
	}

	//General Menu Item Listener for Exit Command--------------------
	class MenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String menuName = event.getActionCommand();
			if (menuName.equals("exit")) {
				System.exit(0); // exit program if "EXIT" menu item is clicked
			}
		}
	}

	private JPanel createDataPanel() {
		String url = "jdbc:mysql://localhost:3306/TestDB";
		String user = "root";
		String password = "Ftw2ftw2!";

		Vector<Vector<Object>> data = new Vector<>();
		Vector<String> columnNames = new Vector<>();

		try (Connection conn = DriverManager.getConnection(url, user, password);
			 java.sql.Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery("SELECT * FROM TestDB.Test_Items")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			// Get column names
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(metaData.getColumnName(i));
			}
			// Retrieve row data
			while (rs.next()) {
				Vector<Object> row = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(rs.getObject(i));
				}
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to a JPanel
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);

		//newPanel = panel;
		return panel;
	}

}

