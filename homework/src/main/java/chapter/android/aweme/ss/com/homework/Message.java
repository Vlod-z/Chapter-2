package chapter.android.aweme.ss.com.homework;

public class Message {
    private String title;
    private String description;
    private String time;
    private int id;

    public Message(String title,String description,String time,int id){
        this.title=title;
        this.description=description;
        this.time=time;
        this.id=id;
    }

    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public String getTime(){return time;}
    public int getId(){return id;}
}
