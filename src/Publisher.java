public class Publisher {
    private int publisher_id;
    private String publisher_name;
    private String publisher_email;
    private String publisher_location;
        public Publisher(int publisher_id, String publisher_name, String publisher_email, String publisher_location){
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
        this.publisher_email = publisher_email;
        this.publisher_location = publisher_location;
    }
    public int getPublisher_id(){
        return publisher_id;
    }
    public String getPublisher_name(){
        return publisher_name;
    }
    public String getPublisher_email(){
        return publisher_email;
    }
    public String getPublisher_location(){
        return publisher_location;
    }

}
