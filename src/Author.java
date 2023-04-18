import java.util.List;

public class Author {
    private String author_name;
    private int author_id;
    public Author(int author_id, String author_name){
        this.author_id = author_id;
        this.author_name = author_name;
    }

    public int getAuthor_id(){
        return author_id;
    }

    public String getAuthor_name(){
        return author_name;
    }
}
