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
    public void addPublicationReference(int publication_id, String reference_title, int reference_year, String reference_pp, String reference_url, String authors) {
        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO addreferences (publication_id, reference_title, reference_year, reference_pp, reference_url, authors) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, publication_id);
            ps.setString(2, reference_title);
            ps.setInt(3, reference_year);
            ps.setString(4, reference_pp);
            ps.setString(5, reference_url);

//            StringBuilder sb = new StringBuilder();
//            for (Author tempAuthor : authors) {
//                sb.append(tempAuthor).append(", ");
//            }
//            String authors1 = sb.toString().substring(0, sb.length() - 2);
                ps.setString(6, authors);
                int i = ps.executeUpdate();
                System.out.println(i + " row(s) inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
