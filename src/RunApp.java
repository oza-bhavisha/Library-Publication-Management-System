import java.util.*;
public class RunApp {
    public static void main(String[] args) {
        int choice;
        DbAccess dba1=new DbAccess();
        String publication_title,publication_type,publication_pages,publication_volume,publication_issue,publication_month,publication_year,venue_name,publisher_name, editor_name, editor_contact, organiser_name,venue_location, organisation_name, organiser_contact, organisation_contact, organisation_homeOffice;
        String author_name="";
        String reference_title, reference_pp, reference_url, authors = null;
        int publication_id, reference_year;
        Scanner scanner=new Scanner(System.in);
        System.out.println("##############################");
        System.out.println("WELCOME TO PUBLICATION LIBRARY");
        System.out.println("##############################");
        start:
        System.out.println("Please choose from below mentioned actions :");
        System.out.println("############################################");
        System.out.println("1. Add Publication");
        System.out.println("2. Add Reference");
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
                dba1.addVenue(venue_name, venue_location);

                System.out.println("ADD PUBLISHER DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Publisher name: ");
                publisher_name=scanner.next();

                System.out.println("ADD EDITOR DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Editor name: ");
                editor_name=scanner.next();
                System.out.println("Enter Editor contact: ");
                editor_contact=scanner.next();
                dba1.addEditor(editor_name, editor_contact);

                System.out.println("ADD ORGANISER DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Organiser name: ");
                organiser_name=scanner.next();
                System.out.println("Enter Organiser contact: ");
                organiser_contact=scanner.next();
                dba1.addOrganiser(organiser_name, organiser_contact);

                System.out.println("ADD ORGANISATION DETAILS :");
                System.out.println("-----------------------");
                System.out.println("Enter Organisation name: ");
                organisation_name=scanner.next();
                System.out.println("Enter Organisation contact: ");
                organisation_contact=scanner.next();
                System.out.println("Enter Organisation homeOffice: ");
                organisation_homeOffice=scanner.next();
                dba1.addOrganisation(organisation_name,organisation_contact, organisation_homeOffice);

                int x;
                System.out.println("How many authors are there to be added ?");
                x=scanner.nextInt();
                for(int i=1;i<=x;i++) {
                    System.out.println("Enter Author "+i+" : ");
                    if (author_name == "") {
                        author_name=scanner.next();
                        dba1.addAuthor(author_name);
                        }
                    else {
                        String dummy;
                        dummy= scanner.next();
                        // add author add here
                        author_name=author_name+ ", " + dummy;
                    }
                }
                System.out.println("author name ="+author_name);
                dba1.addPublication(publication_title, publication_type, publication_pages, publication_volume, publication_issue, publication_month, publication_year, venue_name, publisher_name, editor_name, editor_contact, organiser_name, venue_location, organisation_name);
                break;

                case 2:
                    System.out.println("Enter Publication id: ");
                    publication_id= Integer.parseInt(scanner.next());
                    System.out.println("Enter reference title: ");
                    reference_title=scanner.next();
                    System.out.println("Enter reference year: ");
                    reference_year= Integer.parseInt(scanner.next());
                    System.out.println("Enter reference pages: ");
                    reference_pp=scanner.next();
                    System.out.println("Enter reference url: ");
                    reference_url=scanner.next();
                    dba1.addPublicationReference(publication_id, reference_title, reference_year, reference_pp, reference_url, authors);
                    break;

                    default:
                        System.out.println("Enter valid choice");
                       // goto start;
                        break;
                }
    }
}