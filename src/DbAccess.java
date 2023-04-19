import java.sql.*;
import java.sql.PreparedStatement;
import java.util.List;

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
    public void addEditor(String editor_name, String editor_contact) {
        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO editor (editor_name, editor_contact) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, editor_name);
            ps.setString(2, editor_contact);
            int i = ps.executeUpdate();
            System.out.println(i + " row(s) inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addPublicationReference(int reference_id, int publication_id, String reference_title, int reference_year, String reference_pp, String reference_url, List<Author> authors) {
        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO editor (reference_id, publication_id, reference_title, reference_year, reference_pp, reference_url) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            for (Author obj : authors) {
                ps.setInt(1, obj.reference_id());
                ps.setInt(2, obj.publication_id());
                ps.setString(3, obj.reference_title());
                ps.setInt(4, obj.reference_year());
                ps.setInt(5, obj.reference_pp());
                ps.setInt(6, obj.reference_url());
                ps.setString(7, obj.authors());
                int i = ps.executeUpdate();
                System.out.println(i + " row(s) inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
