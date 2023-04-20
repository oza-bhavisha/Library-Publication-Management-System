import java.util.*;
public class RunApp {
    public static void main(String[] args) {
        int choice;
        DbAccess dba1=new DbAccess();
        String publication_title,publication_type,publication_pages,publication_volume,publication_issue,publication_month,publication_year,venue_name,publisher_name, editor_name,editor_contact = null, organiser_name,venue_location, organisation_name;
        String author_name="";
        Scanner scanner=new Scanner(System.in);
        System.out.println("##############################");
        System.out.println("WELCOME TO PUBLICATION LIBRARY");
        System.out.println("##############################");
        start:
        System.out.println("Please choose from below mentioned actions :");
        System.out.println("############################################");
        System.out.println("1. Add Publication");
        System.out.println("2. Add Reference");
        System.out.println("3. Exit");
        choice =scanner.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter Publication Name: ");
                publication_title=scanner.next();
                System.out.println("Enter Publication Type (Journal / Conference): ");
                publication_type=scanner.next();
                System.out.println("Enter Publication pages: ");
                publication_pages=scanner.next();
                System.out.println("Enter Publication volume: ");
                publication_volume=scanner.next();
                System.out.println("Enter Publication issue: ");
                publication_issue=scanner.next();
                System.out.println("Enter Publication month: ");
                publication_month=scanner.next();
                System.out.println("Enter Publication year: ");
                publication_year=scanner.next();

                System.out.println("ADD VENUE DETAILS :");
                System.out.println("--------------------");
                System.out.println("Enter Venue name: ");
                venue_name=scanner.next();
                System.out.println("Enter Venue location: ");
                venue_location=scanner.next();
                // addVenue call
                dba1.addVenue(venue_name, venue_location);

                System.out.println("ADD PUBLISHER DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Publisher name: ");
                publisher_name=scanner.next();

                System.out.println("ADD EDITOR DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Editor name: ");
                editor_name=scanner.next();
                dba1.addEditor(editor_name, editor_contact);

                System.out.println("ADD ORGANIZER DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Organizer name: ");
                organiser_name=scanner.next();
                //addorganiser
                System.out.println("Enter Organization name: ");
                organisation_name=scanner.next();
                //addorganisation
                int x;
                System.out.println("How many authors are there to be added ?");
                x=scanner.nextInt();
                for(int i=1;i<=x;i++) {
                    System.out.println("Enter Author "+i+" : ");
                    if (author_name=="") {
                        author_name=scanner.next();
                        // add author call method here
                        }
                    else {
                        String dummy;
                        dummy= scanner.next();
                        // add author add here
                        author_name=author_name+ ", " + dummy;
                    }
                }
                System.out.println("author name ="+author_name);
                //addpublication
                //dba1.addPublication(publication_title, publication_year);
                break;
//        case 2:
//            break;
//                    case 3:
//                        break;
                    default:
                        System.out.println("Enter valid choice");
                       // goto start;
                        break;
                }





////        String editor_name,editor_contact;
//        Scanner s = new Scanner(System.in);
////        System.out.print("Enter Editor Name: ");
////        editor_name=s.nextLine();
////        System.out.print("Enter Editor contact: ");
////        editor_contact=s.nextLine();
//        DbAccess test=new DbAccess();
//     //   test.addEditor(editor_name,editor_contact);
//        //declaring variables
//        int publication_id;
//        String reference_title;
//        int reference_year;
//        String reference_pp;
//        String reference_url;
//        List<Author> authors=new ArrayList<>();
//        System.out.print("Enter Publication id: ");
//        publication_id = s.nextInt();
//        System.out.print("Enter reference title: ");
//        reference_title=s.next();
//        System.out.println("Enter reference year: ");
//        reference_year=s.nextInt();
//        System.out.println("Enter reference pages: ");
//        reference_pp= s.next();
//        System.out.println("Enter reference url: ");
//        reference_url= s.next();
//        System.out.println("Enter list of authors: ");
//        Iterator<Author> iterator = authors.iterator();
//        String str=s.next();
//        while (iterator.hasNext()) {
//           str  =str + String.valueOf(iterator.next());
//        }
//        test.addPublicationReference(publication_id, reference_title, reference_year, reference_pp, reference_url, str);

    }
}