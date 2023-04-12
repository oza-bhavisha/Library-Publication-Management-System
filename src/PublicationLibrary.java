import java.util.*;
public class PublicationLibrary {

    private Map<String, Map<String, String>> publications;
    private Map<String, Set<String>> references;
    private Map<String, Map<String, String>> venues;
    private Map<String, Map<String, String>> publishers;
    private Map<String, Set<String>> areas;
    public PublicationLibrary(){
        publications = new HashMap<>();
        references = new HashMap<>();
        venues = new HashMap<>();
        publishers = new HashMap<>();
        areas = new HashMap<>();

    }
    public boolean addPublication(String identifier, Map<String, String> publicationInformation){
        if (!publications.containsKey(identifier)){
            publications.put(identifier, publicationInformation);
            references.put(identifier, new HashSet<>());
            return true;
        }
        return false;

    }

    public boolean addReferences(String identifier, Set<String> references){
        if (publications.containsKey(identifier)) {
            this.references.get(identifier).addAll(references);
            return true;
        }
        return false;

    }
    public boolean addVenue (String venueName, Map<String, String> venueInformation, Set<String> researchAreas){
        if (!venues.containsKey(venueName)){
            venues.put(venueName, venueInformation);
            for (String researchArea : researchAreas) {
                if (!areas.containsKey(researchArea)){
                    areas.put(researchArea, new HashSet<>());
                }
                areas.get(researchArea).add(venueName);
            }
            return true;
        }
        return false;
    }
    public boolean addPublisher(String identifier, Map<String, String> publisherInformation) {
        if (!publishers.containsKey(identifier)) {
            publishers.put(identifier, publisherInformation);
            return true;
        }
        return false;
    }
    public boolean addArea(String researchArea, Set<String> parentArea) {
        if (!areas.containsKey(researchArea)) {
            areas.put(researchArea, parentArea);
            return true;
        }
        return false;
    }

    public Map<String, String> getPublications(String key) {
        Map<String, String> answer = new HashMap<>();
        if (publications.containsKey(key)) {
            answer.putAll(publications.get(key));
            answer.put("references", String.join(",", references.get(key)));
        }
        return answer;
    }

    public int authorCitations ( String author ){
        int total = 0;
        for (Map<String, String> publication : publications.values()) {
            if (publication.containsKey("authors")) {
                for (String authorName : publication.get("authors").split(", ")) {
                    if (authorName.equals(author)) {
                        total++;
                    }
                }
            }
        }
        return total;
    }
    public Set<String> seminalPapers ( String area, int paperCitation, int otherCitations ) {
        // Logic to implement

        return new HashSet<>();
    }

    public Set<String> collaborators( String author, int distance ){
        // Logic to implement

        return new HashSet<>();
    }

    public Set<String> authorResearchAreas ( String author, int threshold ) {
        // Logic to implement

        return new HashSet<>();
    }


}
