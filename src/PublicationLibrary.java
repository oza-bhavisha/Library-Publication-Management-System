import java.util.*;
public class PublicationLibrary {

    private Map<String, Map<String, String>> publications;
    private Map<String, Set<String>> references;
    private Map<String, Set<String>> authorM;
    private Map<String, Map<String, String>> venues;
    private Map<String, Map<String, String>> publishers;
    private Map<String, Set<String>> areas;

    // Constructor creation
    public PublicationLibrary(){
        publications = new HashMap<>();
        references = new HashMap<>();
        venues = new HashMap<>();
        publishers = new HashMap<>();
        areas = new HashMap<>();
    }

    /**
     * Adds a new publication to the collection of publications, identified by the given identifier, and populates it with the given publication information.
     * @param identifier a String representing the unique identifier of the publication to be added
     * @param publicationInformation a Map of key-value pairs representing the publication information to be stored
     * @return true if the publication was successfully added, false otherwise
     */
    public boolean addPublication(String identifier, Map<String, String> publicationInformation){
        if (!publications.containsKey(identifier)){
            publications.put(identifier, publicationInformation);
            references.put(identifier, new HashSet<>());
            return true;
        }
        return false;
    }

    /**
     * Adds a set of references to the existing references of a publication identified by the given identifier.
     * @param identifier the unique identifier of the publication to add references to
     * @param references a set of references to be added to the publication's existing references
     * @return true if the references were added successfully, false otherwise (i.e., if the publication with the given identifier does not exist)
     */
    public boolean addReferences(String identifier, Set<String> references){
        if (publications.containsKey(identifier)) {
            this.references.get(identifier).addAll(references);
            return true;
        }
        return false;
    }

    /**
     * Adds a new venue with the given name and information to the system.
     * Also associates the venue with the given research areas.
     * @param venueName the name of the venue to add
     * @param venueInformation the information associated with the venue
     * @param researchAreas a set of research areas associated with the venue
     * @return true if the venue was added successfully, false if a venue with the same name already exists
     */
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

    /**
     * Adds a publisher to the collection of publishers if it does not already exist.
     * @param identifier the identifier of the publisher to add
     * @param publisherInformation a map containing information about the publisher to add
     * @return true if the publisher was added successfully, false if a publisher with the same identifier already exists
     */
    public boolean addPublisher(String identifier, Map<String, String> publisherInformation) {
        if (!publishers.containsKey(identifier)) {
            publishers.put(identifier, publisherInformation);
            return true;
        }
        return false;
    }
    /**
     * Adds a new research area to the areas map with the given name and parent areas.\
     * @param researchArea the name of the research area to be added
     * @param parentArea a set of names of the parent research areas of the new area
     * @return true if the research area is successfully added to the map, false otherwise
     */
    public boolean addArea(String researchArea, Set<String> parentArea) {
        if (!areas.containsKey(researchArea)) {
            areas.put(researchArea, parentArea);
            return true;
        }
        return false;
    }

    /**
     * Returns a map of publications and their associated references based on the specified key.
     * @param key the key used to retrieve the publications and their references.
     * @return a Map<String, String> containing the publications and their references if the key is found, otherwise an empty map.
     */
    public Map<String, String> getPublications(String key) {
        Map<String, String> answer = new HashMap<>();
        if (publications.containsKey(key)) {
            answer.putAll(publications.get(key));
            answer.put("references", String.join(",", references.get(key)));
        }
        return answer;
    }

    /**
     * Returns the number of citations for a given author in the Map of publications.
     * @param author the name of the author whose citations are to be counted
     * @return the number of citations for the given author
     */
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

    /**
     * Returns a Set of String containing the IDs of the seminal papers in a given research area.
     * A seminal paper is a paper that has at least "paperCitation" citations and is not referred by any other paper that belongs to the same research area and has at least "otherCitations" citations.
     * @param area the research area to look for seminal papers in
     * @param paperCitation the minimum number of citations a paper must have to be considered a seminal paper
     * @param otherCitations the minimum number of citations a paper must have to reference a seminal paper
     * @return a Set of String containing the IDs of the seminal papers in the given research area
     */
    public Set<String> seminalPapers ( String area, int paperCitation, int otherCitations ) {
        Set<String> seminalPapers = new HashSet<>();
        Map<String, Integer> paperReferences = new HashMap<>();
        for (String publicationId : publications.keySet()){
            Map<String, String> publicationInformation = publications.get(publicationId);
            String publicationArea = publicationInformation.get("research_area");
            if (publicationArea != null && areas.containsKey(publicationArea) && areas.get(publicationArea) != null){
                Set<String> publicationReferences = references.getOrDefault(publicationId, new HashSet<>());
                paperReferences.put(publicationId, publicationReferences.size());
                if (publicationArea.equals(area) && publicationReferences.size() >= otherCitations) {
                    boolean isSeminal = true;
                    for (String referenceId : publicationReferences){
                        Map<String, String> referenceInformation = publications.get(referenceId);
                        String referenceArea = referenceInformation.get("research_area");
                        if (referenceArea != null && referenceArea.equals(area) && paperReferences.containsKey(referenceId) && paperReferences.get(referenceId) >= paperCitation){
                            isSeminal = false;
                            break;
                        }
                    }
                    if (isSeminal){
                        seminalPapers.add(publicationId);
                    }
                }
            }
        }
        return seminalPapers;
    }

    public Set<String> collaborators( String author, int distance ) {
        Set<String> collaborators = new HashSet<String>();
        Set<String> visitedAuthors = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(author);
        visitedAuthors.add(author);
        int currentDistance = 0;
        while (!queue.isEmpty() && currentDistance <= distance) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentAuthor = queue.poll();
                Set<String> currentPublications = authorM.get(currentAuthor);
                for (String publication : currentPublications) {
                    Publication pub = (Publication) publications.get(publication);
//                    for (String coauthor : pub.getAuthors() ) {
//                        if (!visitedAuthors.contains(coauthor)) {
//                            visitedAuthors.add(coauthor);
//                            queue.add(coauthor);
//                            if (currentDistance + 1 <= distance) {
//                                collaborators.add(coauthor);
//                            }
//                        }
//                    }
                }
            }
            currentDistance++;
        }
        return collaborators;
    }
    public Set<String> authorResearchAreas ( String author, int threshold ) {
        Set<String> areas = new HashSet<>();
        Map<String, Integer> areaCount = new HashMap<>();

        return areas;
    }
}
