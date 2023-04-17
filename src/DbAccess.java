import java.sql.*;
import java.sql.PreparedStatement;

public class DbAccess {
    public void addPublication(String publication_name, String publication_year) {
        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO publication (publication_name, publication_year) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, publication_name);
            statement.setString(2, publication_year);
            int i = statement.executeUpdate();
            System.out.println(i + " row(s) inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
