public class Venue {
    private int venue_id;
    private String venue_name;
    private String venue_location;
    private String conference_location;
    private int publisher_id;
    private int publication_id;
    public Venue(int venue_id, String venue_name, String venue_location, String conference_location, int publisher_id, int publication_id){
        this.venue_id = venue_id;
        this.venue_name = venue_name;
        this.venue_location = venue_location;
        this.conference_location = conference_location;
        this.publisher_id = publisher_id;
        this.publication_id = publication_id;
    }
    public int getVenue_id(){
        return venue_id;
    }
    public String getVenue_name(){
        return venue_name;
    }
    public String getVenue_location(){
        return venue_location;
    }
    public String getConference_location(){
        return conference_location;
    }
    public int getPublisher_id(){
        return publisher_id;
    }
    public int getPublication_id(){
        return publication_id;
    }

}
