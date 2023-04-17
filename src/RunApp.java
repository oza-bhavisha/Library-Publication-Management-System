import java.util.*;
public class RunApp {
    public static void main(String[] args) {
        String publication_name,publication_year;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Publication Name");
        publication_name=s.nextLine();
        System.out.print("Enter Publication Year");
        publication_year=s.nextLine();
        DbAccess test=new DbAccess();
        test.addPublication(publication_name,publication_year);

    }
}