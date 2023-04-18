import java.util.ArrayList;
import java.util.List;

public class publicationReference {
    private int reference_id;
    private int publication_id;
    private List<Author> authors;
    private String reference_title;
    private int reference_year;
    private String reference_pp;
    private String reference_url;

    public publicationReference(int reference_id, int publication_id, String reference_title, int reference_year,String reference_pp, String reference_url){
        this.reference_id = reference_id;
        this.publication_id = publication_id;
        this.reference_title = reference_title;
        this.reference_year = reference_year;
        this.reference_pp = reference_pp;
        this.reference_url = reference_url;
        this.authors = new ArrayList<>();
    }
    public int getReference_id(){
        return reference_id;
    }
    public int getPublication_id(){
        return publication_id;
    }
    public String getReference_title(){
        return reference_title;
    }
    public int getReference_year(){
        return reference_year;
    }
    public String getReference_pp(){
        return reference_pp;
    }
    public String getReference_url(){
        return reference_url;
    }
    public List<Author> getAuthors(){
        return authors;
    }



}
