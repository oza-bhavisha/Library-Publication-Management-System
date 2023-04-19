public class Editor {
    private int editor_id;
    private String editor_name;
    private String editor_contact;
    public Editor(int editor_id, String editor_name, String editor_contact){
        this.editor_id = editor_id;
        this.editor_name = editor_name;
        this.editor_contact = editor_contact;
    }
    public int getEditor_id(){
        return editor_id;
    }
    public String getEditor_name(){
        return editor_name;
    }
    public String getEditor_contact(){
        return editor_contact;
    }


}
