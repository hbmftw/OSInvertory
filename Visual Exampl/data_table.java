import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class data_table extends JPanel {
    // ...existing code...

    public data_table(Connection connection) throws SQLException {
        setLayout(new BorderLayout());

        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();

        String sql = "SELECT * FROM TestDB.Test_Items";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Get column names
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Retrieve row data
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                data.add(row);
            }
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Add the scroll pane to a JPanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        System.out.println("Data table created successfully.");
    
    }

    // ...existing code...
}

/*
 * // 
 * Add the scroll pane to a JPanel
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(scrollPane, BorderLayout.CENTER);

    // Add the panel to your JFrame or other container
    // frame.add(panel);
 */