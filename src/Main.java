import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final String DB_URL = "jdbc:mysql:///prathamesh";
    static final String USER = "root";
    static final String PASS = "Pratham@13";
    static final String QUERY = "SELECT * FROM users";

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver (Important)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(QUERY)) {

                while (rs.next()) {
                    System.out.print("USER_ID: " + rs.getInt("user_id"));
                    System.out.print(", USER_NAME: " + rs.getString("username"));
                    System.out.println();
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found! Add it to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}