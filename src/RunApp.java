import java.util.*;
public class RunApp {
    public static void main(String[] args) {
//        String editor_name,editor_contact;
        Scanner s = new Scanner(System.in);
//        System.out.print("Enter Editor Name: ");
//        editor_name=s.nextLine();
//        System.out.print("Enter Editor contact: ");
//        editor_contact=s.nextLine();
        DbAccess test=new DbAccess();
     //   test.addEditor(editor_name,editor_contact);
        //declaring variables
        int publication_id;
        String reference_title;
        int reference_year;
        String reference_pp;
        String reference_url;
        List<Author> authors=new ArrayList<>();
        System.out.print("Enter Publication id: ");
        publication_id = s.nextInt();
        System.out.print("Enter reference title: ");
        reference_title=s.next();
        System.out.println("Enter reference year: ");
        reference_year=s.nextInt();
        System.out.println("Enter reference pages: ");
        reference_pp= s.next();
        System.out.println("Enter reference url: ");
        reference_url= s.next();
        System.out.println("Enter list of authors: ");
        Iterator<Author> iterator = authors.iterator();
        String str=s.next();
        while (iterator.hasNext()) {
           str  =str + String.valueOf(iterator.next());
        }
        test.addPublicationReference(publication_id, reference_title, reference_year, reference_pp, reference_url, str);

    }
}