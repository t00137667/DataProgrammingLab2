public class Game {
    private int id = 0;
    private String  title = null;
    private String  publisher = null;
    private int age = 0;

    public Game(){
        setTitle("");
        setPublisher("");
        setAge(0);
    }
    public Game(String title, String publisher, int age){
        setTitle(title);
        setPublisher(publisher);
        setAge(age);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}