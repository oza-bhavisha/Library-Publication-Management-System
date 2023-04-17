import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
        static DatabaseConnection instance;
        static Connection connection;
        private static final String URL = "jdbc:mysql://db.cs.dal.ca:3306?serverTimezone=UTC&useSSL=false";
        private static final String USERNAME = "boza";
        private static final String PASSWORD = "B00935827";

        public DatabaseConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                Statement statement = connection.createStatement();
                statement.execute("use boza;");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public Connection getConnection(){
            return connection;
        }

        // Creating instance to ensure that only one instance of the class is created during the lifetime of the application
        // Concept understood from: https://www.geeksforgeeks.org/singleton-class-java/
        public static DatabaseConnection getInstance() throws SQLException {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
            return instance;
        }
}
