public class ResearchArea {
    private String research_area_name;
    private int research_area_id;
    public ResearchArea(int research_area_id, String research_area_name){
        this.research_area_id = research_area_id;
        this.research_area_name = research_area_name;
    }
    public int getResearch_area_id(){
        return research_area_id;
    }
    public String getResearch_area_name(){
        return research_area_name;
    }
}
