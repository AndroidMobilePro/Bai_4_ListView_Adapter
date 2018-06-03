package proteam.com.bai_4_listview_adapter;

public class User {
    String title;
    String content;
    public User(String title,String content){
        this.title=title;
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
