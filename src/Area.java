public class Area {
    private String area_name;
    private int area_id;
    private int research_area_id;
    public Area(int area_id, String area_name, int research_area_id){
        this.area_id=area_id;
        this.area_name = area_name;
        this.research_area_id = research_area_id;
    }
    public int getArea_id(){
        return area_id;
    }
    public String getArea_name(){
        return area_name;
    }
    public int getResearch_area_id(){
        return research_area_id;
    }
}
