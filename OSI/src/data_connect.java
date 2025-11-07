import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class data_connect {

    Connection conn = null;

    public void connectDB() {
        String url = "jdbc:mysql://localhost:3306/osidb";
        String user = "root";
        String password = "Ftw2ftw2!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    public void closeDB() throws SQLException {
        conn.close();
    }

}