package examples.sda.todoapp.data;

/**
 * Created by angelika on 23.05.17.
 */

public class TaskEntity {
    //TODO stworzyć pola w naszej bazie danych
    private String id;
    private String title;
    private String description;
    private boolean completed;

    public TaskEntity(String id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
