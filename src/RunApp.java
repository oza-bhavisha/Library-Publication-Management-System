import java.util.*;
public class RunApp {
    public static void main(String[] args) {
        String editor_name,editor_contact;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Editor Name: ");
        editor_name=s.nextLine();
        System.out.print("Enter Editor contact: ");
        editor_contact=s.nextLine();
        DbAccess test=new DbAccess();
        test.addEditor(editor_name,editor_contact);

    }
}