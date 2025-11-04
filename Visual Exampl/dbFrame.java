import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class dbFrame {

	database_connect dbConnect;
	Connection connection;

	Statement statement = null;
	ResultSet resultSet = null;
	Vector<Vector<Object>> data = new Vector<>();
	Vector<String> columnNames = new Vector<>();

    void add(database_connect panel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
	try {
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * FROM SELECT * FROM TestDB.`Test_Items");
		
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		// Get column names
		for (int i = 1; i <= columnCount; i++) {
			columnNames.add(metaData.getColumnName(i));
		}
		
		// Retreive row data
		while (resultSet.next()) {
			Vector<Object> row = new Vector<>();
			for (int i = 1; i<= columnCount; i++) {
				row.add(resultSet.getObject(i));
			}
			data.add(row);
		}
	}
	
	catch (SQLException e)
        {e.printStackTrace();}
	// Close resources with a finally block
	finally {
		try {
			if (resultSet != null) resultSet.close();
			if (statement != null) statement.close();
			if (connection != null) connection.close();
			}
		catch (SQLException e)
            {e.printStackTrace();}
		}
		
	JTable table = new JTable(data, columnNames);
	JScrollPane scrollPane new JScrollPane(table);
	
	// Add the scroll pane to a JPanel
	JPanel panel = new JPanel(new BorderLayout());

	public void add(database_connect panel2) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}
	panel.add(scrollPane, BorderLayout.CENTER);
	
	// Add the panel to JFrame
	frame.add(panel);
}
