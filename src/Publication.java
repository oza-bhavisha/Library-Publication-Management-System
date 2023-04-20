import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

public class Publication {
    private int publication_id;
    private String publication_title;
    private String publication_type;
    private String publication_pages;
    private String publication_volume;
    private String publication_issue;
    private String publication_month;
    private int publication_year;
    private String publication_location;
    private int venue_id;
    private List<Author> authors;
    private List<publicationReference> references;

    public Publication(int publication_id, String publication_title, String publication_type, String publication_pages, String publication_volume, String publication_issue, String publication_month, int publication_year, String publication_location, int venue_id){
        this.publication_id = publication_id;
        this.publication_title = publication_title;
        this.publication_type = publication_type;
        this.publication_pages = publication_pages;
        this.publication_volume = publication_volume;
        this.publication_issue = publication_issue;
        this.publication_month = publication_month;
        this.publication_year = publication_year;
        this.publication_location = publication_location;
        this.venue_id = venue_id;
        this.authors = new ArrayList<>();
        this.references = new ArrayList<>();
    }
    public int getPublication_id(){
        return publication_id;
    }

    public String getPublication_title(){
        return publication_title;
    }

    public String getPublication_type(){
        return publication_type;
    }

    public String getPublication_pages(){
        return publication_pages;
    }

    public String getPublication_volume(){
        return publication_volume;
    }

    public String getPublication_issue(){
        return publication_issue;
    }

    public String getPublication_month(){
        return publication_month;
    }

    public int getPublication_year(){
        return publication_year;
    }

    public String getPublication_location(){
        return publication_location;
    }

    public int getVenue_id(){
        return venue_id;
    }

    public List<Author> getAuthors(){
        return authors;
    }

    public List<publicationReference> getReferences() {
        return references;
    }

}
