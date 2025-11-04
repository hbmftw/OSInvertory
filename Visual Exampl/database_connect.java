import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_connect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/TestDB";
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

        // Connection is closed automatically by try-with-resources
    }
}


//Left off at adding database connection results into main window text field.